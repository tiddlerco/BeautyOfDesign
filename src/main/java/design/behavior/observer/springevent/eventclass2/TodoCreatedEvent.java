package design.behavior.observer.springevent.eventclass2;

import design.behavior.observer.springevent.entity.TodoEventData;

/**
 * @Author 喻可
 * @Date 2021/7/19 10:36
 */

public class TodoCreatedEvent extends BaseEvent<TodoEventData> {

    public TodoCreatedEvent(Object source, TodoEventData eventData) {
        super(source, eventData);
    }
}
