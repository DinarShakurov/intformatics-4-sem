package ru.shakurov.pages.position.video;


import ru.shakurov.pages.page.Page;
import ru.shakurov.pages.position.Position;
import ru.shakurov.pages.position.PositionFactory;

public class VideoAdvFactory implements PositionFactory {
    @Override
    public Position create(Page adv) {
        return new VideoAdvPosition(adv);
    }
}
