package dev.webdb.story.repository;

import dev.webdb.story.model.Story;
import java.util.List;

public interface StoryRepository
{
    public Story findStoryById(Long storyId);
    public List<Story> getAllStories();
    public boolean addStory(Story story);
}
