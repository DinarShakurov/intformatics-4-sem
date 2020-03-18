package ru.shakurov.pages.position.text;

import ru.shakurov.pages.page.Page;
import ru.shakurov.pages.position.Position;
import ru.shakurov.pages.position.PositionFactory;

public class TextAdvFactory implements PositionFactory {
    @Override
    public Position create(Page adv) {
        return new TextAdvPosition(adv);
    }
}
