package orgvictoryaxon.photofeed.lib.base;

/**
 * Created by VictorYaxon.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
