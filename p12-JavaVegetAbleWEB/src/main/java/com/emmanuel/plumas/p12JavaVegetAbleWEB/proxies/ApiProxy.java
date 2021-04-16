package com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="p12JavaVegetable-API", url="localhost:9001")
public interface ApiProxy {

}
