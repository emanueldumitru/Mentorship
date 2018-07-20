package com.orange.otheatre.service;

import com.orange.otheatre.entities.Event;
import com.orange.otheatre.entities.UserProfile;
import com.orange.otheatre.repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public Event saveEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    public boolean isEligibileForReview(UserProfile userProfile, Event event) {

        LOGGER.info("Checking if the user attended the event");

        for(Event e : userProfile.getEventsAttended()){
            if(e.getEventTitle().equals(event.getEventTitle())){
                LOGGER.info("The user attended the event.");
                return true;
            }
        }

        LOGGER.info("The user didn't attend the event.");
        return false;

        }


}

