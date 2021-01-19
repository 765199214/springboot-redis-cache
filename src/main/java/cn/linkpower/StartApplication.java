package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class StartApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(StartApplication.class, args);
        
    }
}
