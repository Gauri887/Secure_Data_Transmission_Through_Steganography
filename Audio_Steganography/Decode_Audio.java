/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Audio_Steganography;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Decode_Audio extends javax.swing.JFrame {

    private static final String algorithm = "PBEWithMD5AndDES";
    byte[] plainTextBytes;
    private char password[];
    private byte[] audioBytes;
    
    public Decode_Audio() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSelectAudio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDecoddedMessage = new javax.swing.JTextArea();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAudioPath = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonDecode = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSelectAudio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSelectAudio.setText("Select Audio");
        jButtonSelectAudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelectAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectAudioActionPerformed(evt);
            }
        });

        jTextAreaDecoddedMessage.setColumns(20);
        jTextAreaDecoddedMessage.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextAreaDecoddedMessage.setLineWrap(true);
        jTextAreaDecoddedMessage.setRows(5);
        jTextAreaDecoddedMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Decodded Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jScrollPane1.setViewportView(jTextAreaDecoddedMessage);

        jTextFieldPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password : ");

        jTextFieldAudioPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Decode Audio ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jButtonDecode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDecode.setText("Decode");
        jButtonDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecodeActionPerformed(evt);
            }
        });

        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonDecode, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSelectAudio, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAudioPath)
                            .addComponent(jTextFieldPassword))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSelectAudio, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jTextFieldAudioPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDecode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectAudioActionPerformed
        
        showFileDialog(true);
        
    }//GEN-LAST:event_jButtonSelectAudioActionPerformed

    private void jButtonDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecodeActionPerformed
        if(jTextFieldAudioPath.getText().equals("")
                || jTextFieldPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please First Choose the Audio and Enter Password!");
        }
        else
        extract();
                
    }//GEN-LAST:event_jButtonDecodeActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        
        jTextAreaDecoddedMessage.setText(null);
        jTextFieldPassword.setText(null);
        jTextFieldAudioPath.setText(null);

    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        if(jTextAreaDecoddedMessage.getText().equals(""))
            JOptionPane.showMessageDialog(this, "No Message to Save");
        else
        showFileDialog(false);        
        
    }//GEN-LAST:event_jButtonSaveActionPerformed
    
    
/**************************** Open File or Save File . ****************************/
/*================================================================================*/
    
 private java.io.File showFileDialog(final boolean open) {
    JFileChooser fc = new JFileChooser("Open a File");
    javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
       @Override
       public boolean accept(java.io.File f) {
          String name = f.getName().toLowerCase();
          if(open)
             return f.isDirectory() ||
                name.endsWith(".wav") || name.endsWith(".mp3") || name.endsWith(".au");
          return f.isDirectory()||name.endsWith(".txt");
          }
       @Override
       public String getDescription() {
          if(open)
             return "Audio (*.wav, *.mp3, *.au)";
          return "Text (*.txt)";
          }
       };
    fc.setAcceptAllFileFilterUsed(false);
    fc.addChoosableFileFilter(ff);
 
    java.io.File f = null;
   if(open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
       
       jTextFieldAudioPath.setText(fc.getSelectedFile().getAbsolutePath());
   
    else if(!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
      
        String Message = jTextAreaDecoddedMessage.getText();
        String Path = fc.getSelectedFile().getAbsolutePath();
        
        try {
             PrintWriter out = new PrintWriter(Path+".txt"); 
                out.write(Message);
                out.close();
                JOptionPane.showMessageDialog(this, "Saved Succesfully");
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error!");
        }     
    }
    return f;
    }
 /**************************** End Of File Dialog Window. *************************/
/*================================================================================*/
    
    
    

/*=================================================================================*/    
/******************* All Decoding Functions Start from Here.
     * @return  ***********************/
/*=================================================================================*/       
    public boolean extract() {
        
        audioBytes = readAudio(jTextFieldAudioPath.getText());
        password = jTextFieldPassword.getText().toCharArray();
        
	System.out
		.println("Extracting the encrypted text from the audio file ...");

	System.out
		.println("The audio bytes before extracting the encrypted message length: "
						+ audioBytes.length);
		boolean success = true;
		byte[] buff = decode_text(audioBytes);

		System.out.println("The extracted message length: " + buff.length);
		plainTextBytes = decrypt(buff, password);
                 
		return success;
}
    
    
/** ========================= Decode_Text Method. ==============================.*/
    
    private byte[] decode_text(byte[] data) {
	
		int length = 0;
		int offset = 32;
		// loop through 32 bytes of data to determine text length
		for (int i = 0; i < 32; ++i) // i=24 will also work, as only the 4th
										// byte contains real data
		{
			length = (length << 1) | (data[i] & 1);
		}
		System.out.println("The extracted length is: " + length);

		byte[] result = new byte[length];

		// loop through each byte of text

		for (int b = 0; b < result.length; ++b)

		{
			// loop through each bit within a byte of text

			for (int i = 0; i < 8; ++i, ++offset)
			{
				// assign bit: [(new byte value) << 1] OR [(text byte) AND 1]

				result[b] = (byte) ((result[b] << 1) | (data[offset] & 1));
			}
		}
		return result;
	}
    
/**========================= DeCrypt Method. ** ============================= */
    /**
     * @param cipherText=
     * @param password
     * @return 
     */
public byte[] decrypt(byte[] cipherText, char password[]) {

	System.out.println("Decrypting the cipher message: "
			+ new String(cipherText));
	System.out.println("The cipher message size is: " + cipherText.length);
	System.out
		 .println("The decryption password length: " + password.length);

                PBEKeySpec pbeKeySpec;
		PBEParameterSpec pbeParamSpec;
		SecretKeyFactory keyFac;

		byte[] plainText = null;

		// same salt as in encryption
		byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
				(byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };

		// Same iteration count in encryption
		int count = 20;

		// Create PBE parameter set
		pbeParamSpec = new PBEParameterSpec(salt, count);

		try {
			pbeKeySpec = new PBEKeySpec(password);

			System.out.println("Decrypting the ciphertext ...");

			keyFac = SecretKeyFactory.getInstance(algorithm);
			SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

			// Create PBE Cipher
			Cipher pbeCipher = Cipher.getInstance(algorithm);

			// Initialize PBE Cipher with key and parameters
			pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
                        
			// Decrypt the cipher text
			try {
				plainText = pbeCipher.doFinal(cipherText);
				System.out.println("The decrypted message: "+new String(plainText));   
                                String EncryptedMessage = new String(plainText);               
                                
                                jTextAreaDecoddedMessage.setText(EncryptedMessage);
				System.out.println("The decrypted message length: "
						+ plainText.length);
			} catch (IllegalBlockSizeException | BadPaddingException ex) {
                            JOptionPane.showMessageDialog(this, 
                            "MayBe Password is wrong or Audio is not Encrypted"
                                    + " Or MayBe you encrypted large size of Text! ");
//				System.out.println("Possible password missmatch!!\n");
//				System.out.println("Caught Exception1: " + ex);
			}
                } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException ex) {
		// Handle the error...
		JOptionPane.showMessageDialog(this, 
                "MayBe Password is wrong or Audio is not Encrypted");
	}
	return plainText;
}


/********************** This method to read the input audio file. ******************/
/** ================================================================================/
     * @param audioFilePath
     * @return 
**/
	public static byte[] readAudio(String audioFilePath) {

		System.out.println("Reading the audio file......");

		AudioInputStream audioInputStream = null;
		byte[] audioBytes = null;
		File audioFile = new File(audioFilePath);

		try {
			audioInputStream = AudioSystem.getAudioInputStream(audioFile);
			int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
			// Set an arbitrary buffer size of 1024 frames.
			int numBytes = 154600 * bytesPerFrame;
			audioBytes = new byte[numBytes];

			try {

				audioInputStream.read(audioBytes);

			} catch (Exception ex) {
				System.out.println("Audio file error:" + ex);
			}
		} catch (UnsupportedAudioFileException | IOException e) {
			System.out.println("Audio file error:" + e);
		}

		return audioBytes;
	}

    
/*******************************End of Decoding Functions. **************************/
/*==================================================================================*/
/*==================================================================================*/
/*==================================================================================*/
/*==================================================================================*/

    /**
     * End of Decoding Functions.
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Decode_Audio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDecode;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSelectAudio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDecoddedMessage;
    private javax.swing.JTextField jTextFieldAudioPath;
    private javax.swing.JTextField jTextFieldPassword;
    // End of variables declaration//GEN-END:variables
}
