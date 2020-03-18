package ru.shakurov.pages.browser;

import ru.shakurov.pages.page.Page;
import ru.shakurov.pages.position.Position;

public interface Browser {

    void goTo(String pageName);

    void link(Page page);

    void gotoPosition(int i);

    Page getCurrentPage();

    Position getCurrentPosition();

}
