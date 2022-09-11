package com.springbootpractice.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic(1,"React","A javascript library from frontend programming"),
			new Topic(2,"Java","A programming language"),
			new Topic(3,"MySql","An open-source database system")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(int id) {
		return topics.parallelStream().filter(t -> t.getId()==id).findFirst().get();
	}

	public List<Topic> addTopic(Topic topic) {
		topics.add(topic);
		return topics;
	}
	
	public Topic updateTopic(Topic topic, int id) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId()==id) {
				topics.set(i, topic);
			}
		}
		
		Topic topicUpdated = topics.parallelStream().filter(t -> t.getId()==id).findFirst().get();
		return topicUpdated;
	}
	
	public void deleteTopic(int id) {
		topics.removeIf(t -> t.getId()==id);
	}
}
