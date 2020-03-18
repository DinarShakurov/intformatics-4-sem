package ru.shakurov.pages.storage;


import ru.shakurov.pages.page.Page;

public interface PageStorage {

    Page getPage(String name);

}
