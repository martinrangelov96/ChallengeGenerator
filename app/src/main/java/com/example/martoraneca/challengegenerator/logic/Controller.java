package com.example.martoraneca.challengegenerator.logic;

import com.example.martoraneca.challengegenerator.data.DataSourceInterface;
import com.example.martoraneca.challengegenerator.data.ListItem;
import com.example.martoraneca.challengegenerator.view.ViewInterface;

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();

    }

    public void onItemClick(ListItem testItem) {
        view.startDetailActivity(
                testItem.getDrawables(),
                testItem.getTimes(),
                testItem.getChallenges()
        );
    }

    private void getListFromDataSource() {
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }

    public void createNewListItem() {
        ListItem newItem = dataSource.createNewListItem();

        view.addNewListItemToView(newItem);
    }
}
