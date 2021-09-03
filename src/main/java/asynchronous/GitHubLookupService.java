package asynchronous;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * created by Atiye Mousavi
 * Date: 8/31/2021
 * Time: 8:42 AM
 */

@Service
@Slf4j
public class GitHubLookupService {

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    @Async
    //CompletableFuture برای این است که چندین opration بصورت async اجرا شود و در آخر باهم merge شود
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        log.info("Looking up " + user);
        String url=String.format("https://api.github.com/users/%s",user);
        User results=restTemplate.getForObject(url,User.class);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);

    }
}
