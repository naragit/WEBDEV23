package dev.webdb.story.controller;

import dev.webdb.story.model.Story;
import dev.webdb.story.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("rest/story")
public class StoryController
{
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/hello")
    public String sayHello()
    {
        return  "<h2> Welcome </h2> ";
    }

    @RequestMapping("/getall")
    public List<Story> getAll()
    {
        return storyService.getAllStories();
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public ResponseEntity<Story> findStoryById(@PathVariable("id")Long id) throws Exception{

        try {
            System.out.println(" Inside Control "+id);
            Story story = storyService.findById(id);
            if(story != null)
            {
                return ResponseEntity.ok(story);
            }
            throw new Exception("Data not found");

        }
        catch (Exception e)
        {
            System.out.println(" Error "+e.getMessage());
            throw e;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<String> createStory(@RequestBody Story story) throws Exception
    {
        try
        {
            boolean created = storyService.createStory(story);
            if(created) {
                return ResponseEntity.ok("Created new story");
            }
            throw new Exception("Failed creating story");
        } catch (Exception e){

            e.printStackTrace();
            throw e;
        }

    }
}
