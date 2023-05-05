package data.repositories;

import shita.data.models.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shita.data.repositories.EventRepository;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryImplTest {
    private EventRepository eventRepository;

    @BeforeEach
    public void startWith(){
        eventRepository = new EventRepositoryImpl();
    }

    @Test
    public void saveOneEvent_countIsOneTest(){
        assertEquals(0, eventRepository.count());

        Event event = new Event();
        eventRepository.save(event);

        assertEquals(1, eventRepository.count());

    }

    @Test
    public void saveOneEvent_eventIdIsOneTest(){
        Event event = new Event();
        assertEquals(0, event.getId());

        Event savedEvent = new Event();
        eventRepository.save(savedEvent);
        assertEquals(1, savedEvent.getId());
    }

    @Test
    public void saveOneEvent_FindById_ReturnEventTest(){
        Event event = new Event();
        assertEquals(0, event.getId());

        Event savedEvent = new Event();
        eventRepository.save(savedEvent);
        Event foundEvent = eventRepository.findById(1);
        assertEquals(1, savedEvent.getId());
        assertEquals(savedEvent, foundEvent);
    }

    @Test
    public void saveTwoEvents_SameId_CountIsOneTest(){
        Event event = new Event();
        event.setWhat("christmas groove");
        Event firstEvent = eventRepository.save(event);
        assertEquals(event, firstEvent);

        Event secondEvent = new Event();
        secondEvent.setId(1);
        secondEvent.setWhat("Christmas cruisemas");
        eventRepository.save(secondEvent);

        Event foundEvent = eventRepository.findById(1);

        assertEquals(foundEvent,secondEvent);
        assertNotEquals(foundEvent, firstEvent);
    }

    @Test
    public void saveOneEvent_deleteOneEvent_countIsZeroTest(){
        Event event = new Event();
        eventRepository.save(event);
        assertEquals(1, eventRepository.count());

        eventRepository.delete(1);
        assertEquals(0, eventRepository.count());
    }


}