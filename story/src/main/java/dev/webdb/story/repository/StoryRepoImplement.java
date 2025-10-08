package dev.webdb.story.repository;

import dev.webdb.story.model.Story;
import dev.webdb.story.rowmapper.StoryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoryRepoImplement implements StoryRepository
{


    private final JdbcTemplate jdbcTemplate;
    private final StoryRowMapper storyRowMapper;

    public StoryRepoImplement(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
        this.storyRowMapper = new StoryRowMapper();
    }

    @Override
    public Story findStoryById(Long storyId) {
        try
        {
            Story story = (Story) jdbcTemplate.queryForObject("SELECT *  FROM stories WHERE ID = ?", storyRowMapper, storyId);
            return story;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Story> getAllStories()
    {
        try
        {
            List<Story> storyList =  jdbcTemplate.query("SELECT *  FROM stories", storyRowMapper);
            return storyList;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean addStory(Story story)
    {
        try
        {
            jdbcTemplate.update("INSERT INTO stories(title, body) VALUES (?,?)",story.getTitle(),story.getBody());
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}