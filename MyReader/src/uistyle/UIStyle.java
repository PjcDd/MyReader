package uistyle;

import java.awt.Component;

import javax.swing.UIManager;

public class UIStyle {
	/**
	 * 柔和黑 
	 * "com.jtattoo.plaf.noire.NoireLookAndFeel"
	 */
	public static final int STYLE_NOIRE = 0;

	/**
	 * 木质感+XP风格
	 * "com.jtattoo.plaf.smart.SmartLookAndFeel"
	 */
	public static final int STYLE_SMART = 1;

	/**
	 * 椭圆按钮+黄色按钮背景
	 * "com.jtattoo.plaf.mint.MintLookAndFeel"
	 */
	public static final int STYLE_MINT = 2;
	/**
	 * 椭圆按钮+绿色按钮背景
	 * "com.jtattoo.plaf.mcwin.McWinLookAndFeel"
	 */
	public static final int STYLE_MCWIN = 3;
	/**
	 * 纯XP风格
	 * "com.jtattoo.plaf.luna.LunaLookAndFeel"
	 */
	public static final int STYLE_LUNA = 4;
	/**
	 * 黑色风格
	 * "com.jtattoo.plaf.hifi.HiFiLookAndFeel"
	 */
	public static final int STYLE_HIFI = 5;
	/**
	 * 普通swing风格+蓝色边框
	 * "com.jtattoo.plaf.fast.FastLookAndFeel"
	 */
	public static final int STYLE_FAST = 6;
	/**
	 * 黄色风格
	 * "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel"
	 */
	public static final int STYLE_BERNSTEIN = 7;
	/**
	 * 椭圆按钮+翠绿色按钮背景+金属质感
	 * "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"
	 */
	public static final int STYLE_ALUMINIUM = 8;
	/**
	 * XP清新风格
	 * "com.jtattoo.plaf.aero.AeroLookAndFeel"
	 */
	public static final int STYLE_AERO = 9;
	/**
	 * 布质感+swing纯风格
	 * "com.jtattoo.plaf.acryl.AcrylLookAndFeel"
	 */
	public static final int STYLE_ACRYL = 10;
	/**
	 * "com.jtattoo.plaf.graphite.GraphiteLookAndFeel"
	 */
	public static final int STYLE_GRAPHITE = 11;


	
	
	public static void setUIStyle(Component refreshComponent,int style){
		try{
			switch(style){
			case STYLE_NOIRE:
				UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
				break;
			case STYLE_SMART:
				UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
				break;
				
			case STYLE_MINT:
				UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
				break;	

			case STYLE_MCWIN:
				UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				break;	

			case STYLE_LUNA:
				UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
				break;	

			case STYLE_HIFI:
				UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
				break;	

			case STYLE_FAST:
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				break;	

			case STYLE_BERNSTEIN:
				UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
				break;	

			case STYLE_ALUMINIUM:
				UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
				break;	

			case STYLE_AERO:
				UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
				break;	
			
			case STYLE_ACRYL:
				UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
				break;	
			case STYLE_GRAPHITE:
				UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
				break;			
			}
			javax.swing.SwingUtilities.updateComponentTreeUI(refreshComponent);
		}catch(Exception e){
			System.out.println("设置样式失败："+style);
		}
	}
}
