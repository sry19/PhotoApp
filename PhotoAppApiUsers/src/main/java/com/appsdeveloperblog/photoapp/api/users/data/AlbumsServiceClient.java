package com.appsdeveloperblog.photoapp.api.users.data;

import com.appsdeveloperblog.photoapp.api.users.ui.model.AlbumResponseModel;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="albums-ws",fallbackFactory = AlbumsFallbackFactory.class)
public interface AlbumsServiceClient {

  @GetMapping("/users/{id}/albums")
  public List<AlbumResponseModel> getAlbums(@PathVariable String id);

}

@Component
class AlbumsFallbackFactory implements FallbackFactory<AlbumsServiceClient> {

  @Override
  public AlbumsServiceClient create(Throwable throwable) {
    return new AlbumsServiceClientFallback(throwable);
  }
}

class AlbumsServiceClientFallback implements AlbumsServiceClient {

  Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  private final Throwable throwable;

  AlbumsServiceClientFallback(Throwable throwable) {
    this.throwable = throwable;
  }


  @Override
  public List<AlbumResponseModel> getAlbums(String id) {

    if (throwable instanceof FeignException && ((FeignException) throwable).status() == 404) {
      logger.error("404 error took place when getAlbums was called with userId:" + id
          + ". Error message: " + throwable.getLocalizedMessage());
    } else {
      logger.error("Other error took place:" + throwable.getLocalizedMessage());
    }
    return new ArrayList<>();
  }
}