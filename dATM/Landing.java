	package dATM;
	
	import java.awt.EventQueue;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.RenderingHints;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import java.awt.Color;
	import javax.swing.SwingConstants;
	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.SystemColor;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	public class Landing extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JPanel landingPane;
		private BufferedImage backgroundImage;
		private JTextField userTextField;
		private JTextField passTextField;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Landing frame = new Landing();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		/**
		 * Create the frame.
		 */
		public Landing() {
			setTitle("Dangal ATM");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1024, 768);
	
			try {
				backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\bg.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			// Background panel
			landingPane = new JPanel() {
				private static final long serialVersionUID = 1L;
	
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					if (backgroundImage != null) {
						g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
					}
				}
			};
	
			landingPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(landingPane);
			landingPane.setLayout(null);
			
			JPanel loginPanel = new JPanel();
			loginPanel.setBackground(SystemColor.control);
			loginPanel.setBounds(46, 71, 364, 552);
			landingPane.add(loginPanel);
			loginPanel.setLayout(null);
			
			// Custom panel for logo image
			JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\Dangal ATM.png");
			logoPanel.setBounds(55, 80, 250, 100);
			loginPanel.add(logoPanel);
			
			JLabel customerLabel = new JLabel("USER LOGIN");
			customerLabel.setForeground(new Color(46, 139, 87));
			customerLabel.setFont(new Font("Poppins", Font.BOLD, 25));
			customerLabel.setBackground(Color.GREEN);
			customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
			customerLabel.setBounds(31, 221, 299, 31);
			loginPanel.add(customerLabel);
			
			// Custom panel with rounded corners
			JPanel cuslblPane = new RoundedPanel(30); // 30 is the radius of the corners
			cuslblPane.setBackground(new Color(144, 238, 144));
			cuslblPane.setBounds(31, 210, 299, 53);
			loginPanel.add(cuslblPane);
			
			// Custom panel for profile icon
			JPanel profileIcon = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\user-fill.png");
			profileIcon.setBounds(40, 305, 20, 20);
			loginPanel.add(profileIcon);
			
			userTextField = new JTextField();
			userTextField.setBounds(79, 294, 225, 40);
			loginPanel.add(userTextField);
			userTextField.setColumns(10);
			
			// Custom panel for password icon
			JPanel passIcon = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\git-repository-private-fill.png");
			passIcon.setBounds(40, 353, 20, 20);
			loginPanel.add(passIcon);
			
			passTextField = new JTextField();
			passTextField.setColumns(10);
			passTextField.setBounds(79, 344, 225, 40);
			loginPanel.add(passTextField);
			
			JButton loginBTN = new JButton("Login");
			loginBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			loginBTN.setBackground(new Color(102, 255, 102));
			loginBTN.setBounds(114, 429, 136, 40);
			loginPanel.add(loginBTN);
			
			JLabel lblNewLabel = new JLabel("Activate Account");
			lblNewLabel.setForeground(new Color(46, 139, 87));
			lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(31, 394, 299, 13);
			loginPanel.add(lblNewLabel);
		}
	
		// Custom JPanel class with rounded corners
		class RoundedPanel extends JPanel {
			private static final long serialVersionUID = 1L;
			private int cornerRadius;
	
			public RoundedPanel(int radius) {
				super();
				this.cornerRadius = radius;
				setOpaque(false); // To ensure the background is transparent
			}
	
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(getBackground());
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
			}
		}
	
		// Custom JPanel class for displaying an image
		class ImagePanel extends JPanel {
			private static final long serialVersionUID = 1L;
			private BufferedImage image;
	
			public ImagePanel(String imagePath) {
				try {
					image = ImageIO.read(new File(imagePath));
				} catch (IOException e) {
					e.printStackTrace();
				}
				setOpaque(false);
			}
	
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null) {
					g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				}
			}
		}
	}
