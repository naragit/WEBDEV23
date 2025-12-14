package dev.web.restcall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineImpl implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception        // Runs only during App Startup
    {
        System.out.println(" \nStartup Command Line Runner -- Loading : " + new java.util.Date());
    }
}
