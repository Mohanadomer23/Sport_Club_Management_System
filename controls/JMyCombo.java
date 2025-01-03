/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controls;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.JComboBox;
public class JMyCombo extends JComboBox {
    public JMyCombo()
    {
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g)
    {
        g.setColor(new Color(70,130,180));
        g.drawRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
    }
}
