package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import UEVEZon.models.*;
import UEVEZon.controllers.*;

public class StatView extends JPanel {
    public StatView(StatisticsListener stats){
        super(new BorderLayout());

        JTable table = new JTable(new StatViewModel(stats));
        JScrollPane scroller = new JScrollPane(table);

        JPanel controls = new JPanel();
        //controls.add(buildDetail(table, mag));

        add(controls, BorderLayout.PAGE_START);
        add(scroller, BorderLayout.CENTER);
    }
}




