
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest06 extends JFrame {
  JButton btn = null;

  public static void main(String[] args) {
    ActionTest06 w = new ActionTest06( "ActionTest06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 450 );
    w.setVisible( true );
  }
  public ActionTest06( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new FlowLayout() );
    JMenuBar menubar = new JMenuBar();
    setJMenuBar( menubar );
    JMenu menu1 = new JMenu( "メニュー1" );
    menubar.add( menu1 );
    for( int i=0 ; i<10 ; i++ ){
      Action action = new HideAction();
      action.putValue(Action.NAME, Integer.toString(i));
      action.putValue(Action.SELECTED_KEY, Boolean.TRUE);
      action.putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
      action.putValue( Action.LARGE_ICON_KEY, new ImageIcon( "openL.gif" ) );

      JMenuItem item = new JCheckBoxMenuItem( action ); // 共通のアクションを設定 
      menu1.add( item );
      JCheckBox ck = new JCheckBox( action ); // 共通のアクションを設定 
      ck.setPreferredSize( new Dimension(240, 25) );
      pane.add( ck );
    }

    Action action = new ButtonAction();
    action.putValue( Action.NAME, "新しく開く" ); // "NewOpen" にしてみる
    action.putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
    action.putValue( Action.LARGE_ICON_KEY, new ImageIcon( "openL.gif" ) );
    action.putValue( Action.MNEMONIC_KEY, KeyEvent.VK_O ); // o(オー)キーをニーモニックに
    action.putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY,3 ); // 3(4)文字目にアンダーライン
    btn = new JButton( action );
    pane.add(btn);
  }
  class HideAction extends AbstractAction {
    public void actionPerformed( ActionEvent e ) {
      boolean b =  (Boolean)getValue( Action.SELECTED_KEY ); 
      btn.setHideActionText( !b ); 
    }
  }
  class ButtonAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
    }
  }
}