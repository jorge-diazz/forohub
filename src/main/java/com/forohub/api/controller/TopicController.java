package com.forohub.api.controller;

import com.forohub.api.model.Topic;
import com.forohub.api.record.topic.TopicCreateData;
import com.forohub.api.record.topic.TopicListData;
import com.forohub.api.record.topic.TopicRequestData;
import com.forohub.api.record.topic.TopicUpdateData;
import com.forohub.api.repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<TopicRequestData> createTopic(@RequestBody @Valid TopicCreateData topicCreateData, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicRepository.save(new Topic(topicCreateData));
        TopicRequestData topicRequestData = new TopicRequestData(topic);
        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(topicRequestData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicRequestData> readTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        TopicRequestData topicRequestData = new TopicRequestData(topic);
        return ResponseEntity.ok(topicRequestData);
    }

    @GetMapping
    public ResponseEntity<Page<TopicListData>> readListTopic(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findByActiveTrue(pageable).map(TopicListData::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TopicRequestData> updateTopic(@RequestBody @Valid TopicUpdateData topicUpdateData) {
        Topic topic = topicRepository.getReferenceById(topicUpdateData.id());
        topic.updateData(topicUpdateData);
        return ResponseEntity.ok(new TopicRequestData(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.deactivate();
        //topicRepository.delete(topic);
        return ResponseEntity.noContent().build();
    }
}
