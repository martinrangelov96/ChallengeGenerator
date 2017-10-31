package com.example.martoraneca.challengegenerator.view;

import com.example.martoraneca.challengegenerator.data.ListItem;

import java.util.List;


public interface ViewInterface {

    void startDetailActivity(int color, String time, String challenge);

    void setUpAdapterAndView(List<ListItem> listOfData);

    void addNewListItemToView(ListItem newItem);

}
