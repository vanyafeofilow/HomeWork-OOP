package ru.geekbrains.oop.lesson5.presenters;


import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private View view;
    private Model model;


    public BookingPresenter(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try
        {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }

    }
}
