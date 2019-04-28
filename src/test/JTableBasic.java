package test;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class JTableBasic extends JFrame
{
    private Object[][] data;
    private String[] headers;
    private JTable table;

    public JTableBasic()
    {
        this("");
    }

    public JTableBasic(String title)
    {
        this("", null, null);
    }

    public JTableBasic(String title, Object[][] data, String[] headers)
    {
        super();
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.data = data;
        this.headers = headers;
    }

    public void setData(Object[][] data)
    {
        this.data = data;
    }

    public void setHeaders(String[] headers)
    {
        this.headers = headers;
    }

    @Override
    public void pack()
    {
        this.setSize(new Dimension(headers.length * 120, data.length * 20 + 60));
        table = new JTable(data, headers);
        getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(table, BorderLayout.CENTER);
    }
}
