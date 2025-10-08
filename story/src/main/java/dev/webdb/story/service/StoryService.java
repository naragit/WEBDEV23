package dev.webdb.story.service;

import dev.webdb.story.model.Story;
import dev.webdb.story.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService
{

    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Story findById(Long storyId) {
        return this.storyRepository.findStoryById(storyId);
    }

    public List<Story> getAllStories() {
        return storyRepository.getAllStories();
    }

    public boolean createStory(Story story) {
        return storyRepository.addStory(story);
    }

}
