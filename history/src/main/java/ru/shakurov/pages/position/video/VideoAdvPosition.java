package ru.shakurov.pages.position.video;

import ru.shakurov.pages.browser.Browser;
import ru.shakurov.pages.page.Page;
import ru.shakurov.pages.position.Position;

public class VideoAdvPosition implements Position {

    private Page adv;

    public VideoAdvPosition(Page adv) {
        this.adv = adv;
    }

    @Override
    public void gotoAdv(Browser browser) {
        browser.link(adv);
    }

    @Override
    public void show(Browser browser) {
        this.gotoAdv(browser);
    }
}
