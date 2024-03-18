package innim.fo.api.client;

import innim.fo.api.client.dto.EventResponse;
import innim.fo.api.sys.common.ApiClientResponse;
import innim.fo.api.sys.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "event", url = "http://localhost/event/", configuration = FeignConfig.class)
public interface EventServiceClient {

    @GetMapping(value = "/getEvents", produces = "application/json")
    ResponseEntity<ApiClientResponse<List<EventResponse>>> getEvents();

    @GetMapping(value = "/getEvent", produces = "application/json")
    ResponseEntity<ApiClientResponse<EventResponse>> getEvent(@RequestParam int id);

}
