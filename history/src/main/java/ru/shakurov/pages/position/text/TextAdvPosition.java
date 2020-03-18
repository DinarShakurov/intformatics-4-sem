package ru.shakurov.pages.position.text;

import ru.shakurov.pages.browser.Browser;
import ru.shakurov.pages.page.Page;
import ru.shakurov.pages.position.Position;

public class TextAdvPosition implements Position {

    private Page page;

    public TextAdvPosition(Page page) {
        this.page = page;
    }

    @Override
    public void gotoAdv(Browser browser) {
        browser.link(page);
    }

    @Override
    public void show(Browser browser) {
        // just "show"
    }
}
