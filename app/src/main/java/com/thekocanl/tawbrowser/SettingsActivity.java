package com.thekocanl.tawbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.view.View;
import android.content.SharedPreferences;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.text.InputType;
import android.widget.ImageView;
import android.view.WindowManager;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    private LinearLayout hpuLayout, aaLayout, ppLayout, ddoLayout, sfLayout, seLayout, uaLayout, atLayout, alLayout, sttlLayout, tlLayout, ccacLayout, aaLayoutLink, aaLayout1, aaLayout2, aaLayout3;
	private TextView hpuTextView, seTextView, uaTextView, atTextView, alTextView, langLTV, langRTV, sttlTextView, jbTextView, ibTextView, cbTextView, ccacTextView;
	private ImageView backPage;
	private CheckBox jbCheckBox, ibCheckBox, cbCheckBox;
	
	// Arama Motoru Int
	private int secheckItemValue = 0;
	// Arama Motoru String
	private String secheckItemString = "";
	// Kullanıcı Aracısı Int
	private int uacheckItemValue = 0;
	// Kullanıcı Aracısı String
	private String uacheckItemString = "";
	// Uygulama Teması Int
	private int atcheckItemValue = 0;
	// Uygulama Teması String
	private String atcheckItemString = "";
	// Uygulama Dili Int
	private int alcheckItemValue = 45;
	// Uygulama Dili String
	private String alcheckItemString = "";
	// Çevirmen Dili L Int
	private int langltvcheckItemValue = 0;
	// Çevirmen Dili L String
	private String langltvcheckItemString = "";
	// Çevirmen Dili R Int
	private int langrtvcheckItemValue = 1;
	// Çevirmen Dili R String
	private String langrtvcheckItemString = "";
	// Speech To Text Dili Int
	private int sttlcheckItemValue = 0;
	// Speech To Text Dili String
	private String sttlcheckItemString = "";
	// About Page On Off
	private Boolean aboutpage = false;
	// About Page AlertDialog Title
	private String aaLayoutTitle = "";
	// About Page AlertDialog Url
	private String aaLayoutUrl = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
		
        // hpuLayout FindId
        hpuLayout = findViewById(R.id.hpuLayout);
		// aaLayout FindId
		aaLayout = findViewById(R.id.aaLayout);
		// ppLayout FindId
		ppLayout = findViewById(R.id.ppLayout);
		// ddoLayout FindId
		ddoLayout = findViewById(R.id.ddoLayout);
		// sfLayout FindId
		sfLayout = findViewById(R.id.sfLayout);
		// seLayout FindId
		seLayout = findViewById(R.id.seLayout);
		// uaLayout FindId
		uaLayout = findViewById(R.id.uaLayout);
		// atLayout FindId
		atLayout = findViewById(R.id.atLayout);
		// alLayout FindId
		alLayout = findViewById(R.id.alLayout);
		// langLTV FindId
		langLTV = findViewById(R.id.langLTV);
		// langRTV FindId
		langRTV = findViewById(R.id.langRTV);
		// sttlLayout FindId
		sttlLayout = findViewById(R.id.sttlLayout);
		// sttlTextView FindId
		sttlTextView = findViewById(R.id.sttlTextView);
		// tlLayout FindId
		tlLayout = findViewById(R.id.tlLayout);
		// jbCheckBox FindId
		jbCheckBox = findViewById(R.id.jbCheckBox);
		// jbTextView FindId
		jbTextView = findViewById(R.id.jbTextView);
		// ibCheckBox FindId
		ibCheckBox = findViewById(R.id.ibCheckBox);
		// ibTextView FindId
		ibTextView = findViewById(R.id.ibTextView);
		// cbCheckBox FindId
		cbCheckBox = findViewById(R.id.cbCheckBox);
		// cbTextView FindId
		cbTextView = findViewById(R.id.cbTextView);
		// ccacLayout FindId
		ccacLayout = findViewById(R.id.ccacLayout);
		// ccacTextView FindId
		ccacTextView = findViewById(R.id.ccacTextView);
		// backPage FindId
		backPage = findViewById(R.id.backPage);
		// hpuTextView FindId
		hpuTextView = findViewById(R.id.hpuTextView);
		// seTextView FindId
		seTextView = findViewById(R.id.seTextView);
		// uaTextView FindId
		uaTextView = findViewById(R.id.uaTextView);
		// atTextView FindId
		atTextView = findViewById(R.id.atTextView);
		// alTextView FindId
		alTextView = findViewById(R.id.alTextView);
		
        // hpuLayout OnClick
        hpuLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                hpuLayout();
            }
        });
		
		// aaLayout OnClick
		aaLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				aaLayout();
			}
		});
		
		// ppLayout OnClick
		ppLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ppLayout();
			}
		});
		
		// ddoLayout OnClick
		ddoLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ddoLayout();
			}
		});
		
		// sfLayout OnClick
		sfLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				sfLayout();
			}
		});
		
		// seLayout OnClick
		seLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				seLayout();
			}
		});
		
		// uaLayout OnClick
		uaLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				uaLayout();
			}
		});
		
		// uaLayout OnClick
		atLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				atLayout();
			}
		});
		
		// uaLayout OnClick
		alLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				alLayout();
			}
		});
		
		// langLTV OnClick
		langLTV.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				langLTV();
			}
		});
		
		// langRTV OnClick
		langRTV.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				langRTV();
			}
		});
		
		// sttlLayout OnClick
		sttlLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				sttlLayout();
			}
		});
		
		// sttlLayout OnClick
		tlLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				langLTV();
			}
		});
		
		// jbCheckBox OnClick
		jbCheckBox.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				if (jbCheckBox.isChecked() == true) {
					//
					//Toast.makeText(SettingsActivity.this, "true", Toast.LENGTH_SHORT).show();
					jbTextView.setText("JavaScript Engelle (Etkin)");
					//
					SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					spe.putBoolean("JBCHECKBOX", true);
					spe.putInt("JBCHECKBOXCHANGE", 1);
					spe.apply();
				}
				if (jbCheckBox.isChecked() == false) {
					//
					//Toast.makeText(SettingsActivity.this, "false", Toast.LENGTH_SHORT).show();
					jbTextView.setText("JavaScript Engelle (Devredışı)");
					//
					SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					spe.putBoolean("JBCHECKBOX", false);
					spe.putInt("JBCHECKBOXCHANGE", 0);
					spe.apply();
				}
			}
		});
		
		// ibCheckBox OnClick
		ibCheckBox.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				if (ibCheckBox.isChecked() == true) {
					//
					//Toast.makeText(SettingsActivity.this, "true", Toast.LENGTH_SHORT).show();
					ibTextView.setText("Resim Engelle (Etkin)");
					//
					SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					spe.putBoolean("IBCHECKBOX", true);
					spe.putInt("IBCHECKBOXCHANGE", 1);
					spe.apply();
				}
				if (ibCheckBox.isChecked() == false) {
					//
					//Toast.makeText(SettingsActivity.this, "false", Toast.LENGTH_SHORT).show();
					ibTextView.setText("Resim Engelle (Devredışı)");
					//
					SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					spe.putBoolean("IBCHECKBOX", false);
					spe.putInt("IBCHECKBOXCHANGE", 0);
					spe.apply();
				}
			}
		});
		
		// cbCheckBox OnClick
		cbCheckBox.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				if (cbCheckBox.isChecked() == true) {
					//
					//Toast.makeText(SettingsActivity.this, "true", Toast.LENGTH_SHORT).show();
					cbTextView.setText("Çerezleri Engelle (Etkin)");
					//
					SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					spe.putBoolean("CBCHECKBOX", true);
					spe.putInt("CBCHECKBOXCHANGE", 1);
					spe.apply();
				}
				if (cbCheckBox.isChecked() == false) {
					//
					//Toast.makeText(SettingsActivity.this, "false", Toast.LENGTH_SHORT).show();
					cbTextView.setText("Çerezleri Engelle (Devredışı)");
					//
					SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					spe.putBoolean("CBCHECKBOX", false);
					spe.putInt("CBCHECKBOXCHANGE", 0);
					spe.apply();
				}
			}
		});
		
		// ccacLayout OnClick AlertDialog
		ccacLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// Setup the alert builder
				AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
				builder.setMessage("Çerezler ve Önbellek temizlensin mi?");
				// Add - Evet and Hayır - buttons
				builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// User clicked Temizle
						//
						Toast.makeText(SettingsActivity.this, "Çerezler ve Önbellek temizlendi", Toast.LENGTH_SHORT).show();
						ccacTextView.setText("0 MB / 0 MB");
					}
				});
				builder.setNegativeButton("Hayır", null);
				// Create and show the alert dialog
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		// backPage OnClick
		backPage.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if(aboutpage == true) {
					startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));
				}
				else {
				    startActivity(new Intent(SettingsActivity.this, WebActivity.class));
				}
			}
		});
		
		// Start Settings
		startSettings();
    }
	
	// Start Settings
	private void startSettings() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("HOMEPAGEURLCHANGE", 0) == 1) {
			hpuTextView.setText(""+sp.getString("HOMEPAGEURL", ""));
		}
		//
		if (sp.getInt("HOMEPAGEURLCHANGE", 0) == 0) {
			hpuTextView.setText(getResources().getString(R.string.home_url));
		}
		//
		if (sp.getInt("SEARCHENGINECHANGE", 0) == 1) {
			findIntSearchEngine();
			secheckItemString = ""+sp.getString("SEARCHENGINESTRING", "");
			seTextView.setText(""+sp.getString("SEARCHENGINESTRING", ""));
		}
		//
		if (sp.getInt("SEARCHENGINECHANGE", 0) == 0) {
			secheckItemValue = 0;
			secheckItemString = "Google";
			seTextView.setText(""+secheckItemString+"");
		}
		//
		if (sp.getInt("USERAGENTCHANGE", 0) == 1) {
			findIntUserAgent();
			uacheckItemString = ""+sp.getString("USERAGENTSTRING", "");
			uaTextView.setText(""+sp.getString("USERAGENTSTRING", ""));
		}
		//
		if (sp.getInt("USERAGENTCHANGE", 0) == 0) {
			uacheckItemValue = 0;
			uacheckItemString = "Mobil";
			uaTextView.setText(""+uacheckItemString+"");
		}
		//
		if (sp.getInt("APPTHEMECHANGE", 0) == 1) {
			findIntAppTheme();
			atcheckItemString = ""+sp.getString("APPTHEMESTRING", "");
			atTextView.setText(""+sp.getString("APPTHEMESTRING", ""));
		}
		//
		if (sp.getInt("APPTHEMECHANGE", 0) == 0) {
			atcheckItemValue = 0;
			atcheckItemString = "Aydınlık Tema";
			atTextView.setText(""+atcheckItemString+"");
		}
		//
		if (sp.getInt("APPLANGCHANGE", 0) == 1) {
			findIntAppLang();
			alcheckItemString = ""+sp.getString("APPLANGSTRING", "");
			alTextView.setText(""+sp.getString("APPLANGSTRING", ""));
		}
		//
		if (sp.getInt("APPLANGCHANGE", 0) == 0) {
			alcheckItemValue = 45;
			alcheckItemString = "Turkish";
			alTextView.setText(""+alcheckItemString+"");
		}
		//
		if (sp.getInt("LANGLTVCHANGE", 0) == 1) {
			findIntLangLTV();
			langltvcheckItemString = ""+sp.getString("LANGLTVSTRING", "");
			langLTV.setText(""+sp.getString("LANGLTVSTRING", ""));
		}
		//
		if (sp.getInt("LANGLTVCHANGE", 0) == 0) {
			langltvcheckItemValue = 0;
			langltvcheckItemString = "Turkish";
			langLTV.setText(""+langltvcheckItemString+"");
		}
		//
		if (sp.getInt("LANGRTVCHANGE", 0) == 1) {
			findIntLangRTV();
			langrtvcheckItemString = ""+sp.getString("LANGRTVSTRING", "");
			langRTV.setText(""+sp.getString("LANGRTVSTRING", ""));
		}
		//
		if (sp.getInt("LANGRTVCHANGE", 0) == 0) {
			langrtvcheckItemValue = 1;
			langrtvcheckItemString = "English";
			langRTV.setText(""+langrtvcheckItemString+"");
		}
		//
		if (sp.getInt("STTLANGCHANGE", 0) == 1) {
			findIntSpeakToTextLang();
			sttlcheckItemString = ""+sp.getString("STTLANGSTRING", "");
			sttlTextView.setText(""+sp.getString("STTLANGSTRING", ""));
		}
		//
		if (sp.getInt("STTLANGCHANGE", 0) == 0) {
			sttlcheckItemValue = 0;
			sttlcheckItemString = "Turkish";
			sttlTextView.setText(""+sttlcheckItemString+"");
		}
		//
		if (sp.getInt("JBCHECKBOXCHANGE", 0) == 1) {
			jbCheckBox.setChecked(true);
			jbTextView.setText("JavaScript Engelle (Etkin)");
		}
		//
		if (sp.getInt("JBCHECKBOXCHANGE", 0) == 0) {
			jbCheckBox.setChecked(false);
			jbTextView.setText("JavaScript Engelle (Devredışı)");
		}
		//
		if (sp.getInt("IBCHECKBOXCHANGE", 0) == 1) {
			ibCheckBox.setChecked(true);
			ibTextView.setText("Resim Engelle (Etkin)");
		}
		//
		if (sp.getInt("IBCHECKBOXCHANGE", 0) == 0) {
			ibCheckBox.setChecked(false);
			ibTextView.setText("Resim Engelle (Devredışı)");
		}
		//
		if (sp.getInt("CBCHECKBOXCHANGE", 0) == 1) {
			cbCheckBox.setChecked(true);
			cbTextView.setText("Çerezleri Engelle (Etkin)");
		}
		//
		if (sp.getInt("CBCHECKBOXCHANGE", 0) == 0) {
			cbCheckBox.setChecked(false);
			cbTextView.setText("Çerezleri Engelle (Devredışı)");
		}
	}
	
	// Find Int Search Engine
	private void findIntSearchEngine() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("SEARCHENGINEINT", 0) == 0) {
			//
			secheckItemValue = 0;
		}
		if (sp.getInt("SEARCHENGINEINT", 1) == 1) {
			//
			secheckItemValue = 1;
		}
		if (sp.getInt("SEARCHENGINEINT", 2) == 2) {
			//
			secheckItemValue = 2;
		}
		if (sp.getInt("SEARCHENGINEINT", 3) == 3) {
			//
			secheckItemValue = 3;
		}
		if (sp.getInt("SEARCHENGINEINT", 4) == 4) {
			//
			secheckItemValue = 4;
		}
		if (sp.getInt("SEARCHENGINEINT", 5) == 5) {
			//
			secheckItemValue = 5;
		}
		if (sp.getInt("SEARCHENGINEINT", 6) == 6) {
			//
			secheckItemValue = 6;
		}
		if (sp.getInt("SEARCHENGINEINT", 7) == 7) {
			//
			secheckItemValue = 7;
		}
	}
	
	// Find Int User Agent
	private void findIntUserAgent() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("USERAGENTINT", 0) == 0) {
			//
			uacheckItemValue = 0;
		}
		if (sp.getInt("USERAGENTINT", 1) == 1) {
			//
			uacheckItemValue = 1;
		}
	}
	
	// Find Int App Theme
	private void findIntAppTheme() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("APPTHEMEINT", 0) == 0) {
			//
			atcheckItemValue = 0;
		}
		if (sp.getInt("APPTHEMEINT", 1) == 1) {
			//
			atcheckItemValue = 1;
		}
	}
	
	// Find Int App Lang
	private void findIntAppLang() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("APPLANGINT", 0) == 0) {
			//
			alcheckItemValue = 0;
		}
		if (sp.getInt("APPLANGINT", 1) == 1) {
			//
			alcheckItemValue = 1;
		}
		if (sp.getInt("APPLANGINT", 2) == 2) {
			//
			alcheckItemValue = 2;
		}
		if (sp.getInt("APPLANGINT", 3) == 3) {
			//
			alcheckItemValue = 3;
		}
		if (sp.getInt("APPLANGINT", 4) == 4) {
			//
			alcheckItemValue = 4;
		}
		if (sp.getInt("APPLANGINT", 5) == 5) {
			//
			alcheckItemValue = 5;
		}
		if (sp.getInt("APPLANGINT", 6) == 6) {
			//
			alcheckItemValue = 6;
		}
		if (sp.getInt("APPLANGINT", 7) == 7) {
			//
			alcheckItemValue = 7;
		}
		if (sp.getInt("APPLANGINT", 8) == 8) {
			//
			alcheckItemValue = 8;
		}
		if (sp.getInt("APPLANGINT", 9) == 9) {
			//
			alcheckItemValue = 9;
		}
		if (sp.getInt("APPLANGINT", 10) == 10) {
			//
			alcheckItemValue = 10;
		}
		if (sp.getInt("APPLANGINT", 11) == 11) {
			//
			alcheckItemValue = 11;
		}
		if (sp.getInt("APPLANGINT", 12) == 12) {
			//
			alcheckItemValue = 12;
		}
		if (sp.getInt("APPLANGINT", 13) == 13) {
			//
			alcheckItemValue = 13;
		}
		if (sp.getInt("APPLANGINT", 14) == 14) {
			//
			alcheckItemValue = 14;
		}
		if (sp.getInt("APPLANGINT", 15) == 15) {
			//
			alcheckItemValue = 15;
		}
		if (sp.getInt("APPLANGINT", 16) == 16) {
			//
			alcheckItemValue = 16;
		}
		if (sp.getInt("APPLANGINT", 17) == 17) {
			//
			alcheckItemValue = 17;
		}
		if (sp.getInt("APPLANGINT", 18) == 18) {
			//
			alcheckItemValue = 18;
		}
		if (sp.getInt("APPLANGINT", 19) == 19) {
			//
			alcheckItemValue = 19;
		}
		if (sp.getInt("APPLANGINT", 20) == 20) {
			//
			alcheckItemValue = 20;
		}
		if (sp.getInt("APPLANGINT", 21) == 21) {
			//
			alcheckItemValue = 21;
		}
		if (sp.getInt("APPLANGINT", 22) == 22) {
			//
			alcheckItemValue = 22;
		}
		if (sp.getInt("APPLANGINT", 23) == 23) {
			//
			alcheckItemValue = 23;
		}
		if (sp.getInt("APPLANGINT", 24) == 24) {
			//
			alcheckItemValue = 24;
		}
		if (sp.getInt("APPLANGINT", 25) == 25) {
			//
			alcheckItemValue = 25;
		}
		if (sp.getInt("APPLANGINT", 26) == 26) {
			//
			alcheckItemValue = 26;
		}
		if (sp.getInt("APPLANGINT", 27) == 27) {
			//
			alcheckItemValue = 27;
		}
		if (sp.getInt("APPLANGINT", 28) == 28) {
			//
			alcheckItemValue = 28;
		}
		if (sp.getInt("APPLANGINT", 29) == 29) {
			//
			alcheckItemValue = 29;
		}
		if (sp.getInt("APPLANGINT", 30) == 30) {
			//
			alcheckItemValue = 30;
		}
		if (sp.getInt("APPLANGINT", 31) == 31) {
			//
			alcheckItemValue = 31;
		}
		if (sp.getInt("APPLANGINT", 32) == 32) {
			//
			alcheckItemValue = 32;
		}
		if (sp.getInt("APPLANGINT", 33) == 33) {
			//
			alcheckItemValue = 33;
		}
		if (sp.getInt("APPLANGINT", 34) == 34) {
			//
			alcheckItemValue = 34;
		}
		if (sp.getInt("APPLANGINT", 35) == 35) {
			//
			alcheckItemValue = 35;
		}
		if (sp.getInt("APPLANGINT", 36) == 36) {
			//
			alcheckItemValue = 36;
		}
		if (sp.getInt("APPLANGINT", 37) == 37) {
			//
			alcheckItemValue = 37;
		}
		if (sp.getInt("APPLANGINT", 38) == 38) {
			//
			alcheckItemValue = 38;
		}
		if (sp.getInt("APPLANGINT", 39) == 39) {
			//
			alcheckItemValue = 39;
		}
		if (sp.getInt("APPLANGINT", 40) == 40) {
			//
			alcheckItemValue = 40;
		}
		if (sp.getInt("APPLANGINT", 41) == 41) {
			//
			alcheckItemValue = 41;
		}
		if (sp.getInt("APPLANGINT", 42) == 42) {
			//
			alcheckItemValue = 42;
		}
		if (sp.getInt("APPLANGINT", 43) == 43) {
			//
			alcheckItemValue = 43;
		}
		if (sp.getInt("APPLANGINT", 44) == 44) {
			//
			alcheckItemValue = 44;
		}
		if (sp.getInt("APPLANGINT", 45) == 45) {
			//
			alcheckItemValue = 45;
		}
		if (sp.getInt("APPLANGINT", 46) == 46) {
			//
			alcheckItemValue = 46;
		}
		if (sp.getInt("APPLANGINT", 47) == 47) {
			//
			alcheckItemValue = 47;
		}
		if (sp.getInt("APPLANGINT", 48) == 48) {
			//
			alcheckItemValue = 48;
		}
	}
	
	// Find Int LangLTV
	private void findIntLangLTV() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("LANGLTVINT", 0) == 0) {
			//
			langltvcheckItemValue = 0;
		}
		if (sp.getInt("LANGLTVINT", 1) == 1) {
			//
			langltvcheckItemValue = 1;
		}
	}
	
	// Find Int LangRTV
	private void findIntLangRTV() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("LANGRTVINT", 0) == 0) {
			//
			langrtvcheckItemValue = 0;
		}
		if (sp.getInt("LANGRTVINT", 1) == 1) {
			//
			langrtvcheckItemValue = 1;
		}
	}
	
	// Find Int LangRTV
	private void findIntSpeakToTextLang() {
		SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		//
		if (sp.getInt("STTLANGINT", 0) == 0) {
			//
			sttlcheckItemValue = 0;
		}
		if (sp.getInt("STTLANGINT", 1) == 1) {
			//
			sttlcheckItemValue = 1;
		}
	}
	
    // hpuLayout AlertDialog
    private void hpuLayout() {
        // Creating alert dialog with one button
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this);
        // Setting dialog message
        alertDialog.setMessage("Anasayfa Url'si giriniz");
        final EditText input = new EditText(SettingsActivity.this);
	    SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
		SharedPreferences.Editor spe = sp.edit();
		input.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
        input.setText(""+sp.getString("HOMEPAGEURL", ""));
        if (sp.getInt("HOMEPAGEURLCHANGE", 0) == 1) {
            //
            input.setText(""+sp.getString("HOMEPAGEURL", ""));
            hpuTextView.setText(""+sp.getString("HOMEPAGEURL", ""));
        }
        else {
            //
            input.setText(""+getResources().getString(R.string.home_url));
            hpuTextView.setText(""+getResources().getString(R.string.home_url));
            //
            spe.putString("HOMEPAGEURL", ""+getResources().getString(R.string.home_url));
            spe.apply();
        }
        alertDialog.setView(input);
        // Setting positive "Uygula" button
        alertDialog.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
                spe.putString("HOMEPAGEURL", ""+input.getText());
				spe.putInt("HOMEPAGEURLCHANGE", 1);
                spe.apply();
				hpuTextView.setText(""+sp.getString("HOMEPAGEURL", ""));
            }
        });
		// Setting neutral "Varsayılan" button
		alertDialog.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to execute after dialog
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putString("HOMEPAGEURL", getResources().getString(R.string.home_url));
				spe.putInt("HOMEPAGEURLCHANGE", 0);
				spe.apply();
				startSettings();
			}
		});
        // Setting negative "İptal" button
        alertDialog.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog
                dialog.cancel();
            }
        });
        // closed
        // Showing alert message
        alertDialog.show();
    }
	
	// seLayout AlertDialog
	private void seLayout() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Arama Motoru seçiniz");
		// Add a radio button list
		String[] se = {"Google", "Bing", "Yandex","DuckDuckGo","Startpage","Yahoo","Ask","Wow"};
		final int checkedItem = secheckItemValue; // Google
		builder.setSingleChoiceItems(se, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Google
					    secheckItemValue = 0;
						secheckItemString = "Google";
						//
						break;
					case 1: // Bing
					    secheckItemValue = 1;
						secheckItemString = "Bing";
						//
					    break;
					case 2: // Yandex
					    secheckItemValue = 2;
						secheckItemString = "Yandex";
						//
					    break;
					case 3: // DuckDuckGo
					    secheckItemValue = 3;
						secheckItemString = "DuckDuckGo";
						//
					    break;
					case 4: // Startpage
					    secheckItemValue = 4;
						secheckItemString = "Startpage";
						//
					    break;
					case 5: // Yahoo
					    secheckItemValue = 5;
						secheckItemString = "Yahoo";
						//
					    break;
					case 6: // Ask
					    secheckItemValue = 6;
						secheckItemString = "Ask";
						//
					    break;
					case 7: // Wow
					    secheckItemValue = 7;
						secheckItemString = "Wow";
						//
					    break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("SEARCHENGINEINT", secheckItemValue);
                spe.putString("SEARCHENGINESTRING", ""+secheckItemString+"");
				spe.putInt("SEARCHENGINECHANGE", 1);
                spe.apply();
				seTextView.setText(""+sp.getString("SEARCHENGINESTRING", ""));
				//
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("SEARCHENGINEINT", 0);
                spe.putString("SEARCHENGINESTRING", "Google");
				spe.putInt("SEARCHENGINECHANGE", 0);
                spe.apply();
				seTextView.setText(""+sp.getString("SEARCHENGINESTRING", ""));
				//
				secheckItemValue = 0;
				secheckItemString = "Google";
				dialog.cancel();
				//seLayout();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("SEARCHENGINECHANGE", 0) == 1) {
				    findIntSearchEngine();
				    secheckItemString = ""+sp.getString("SEARCHENGINESTRING", "")+"";
				    seTextView.setText(""+sp.getString("SEARCHENGINESTRING", ""));
				}
				else {
					secheckItemValue = 0;
					secheckItemString ="Google";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	// uaLayout AlertDialog
	private void uaLayout() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Kullanıcı Aracısı seçiniz");
		// Add a radio button list
		String[] ua = {"Mobil", "Masaüstü"};
		int checkedItem = uacheckItemValue; // Mobil
		builder.setSingleChoiceItems(ua, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Mobil
					    uacheckItemValue = 0;
						uacheckItemString = "Mobil";
					    //
					    break;
					case 1: // Masaüstü
					    uacheckItemValue = 1;
						uacheckItemString = "Masaüstü";
					    //
						break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("USERAGENTINT", uacheckItemValue);
                spe.putString("USERAGENTSTRING", ""+uacheckItemString+"");
				spe.putInt("USERAGENTCHANGE", 1);
                spe.apply();
				uaTextView.setText(""+sp.getString("USERAGENTSTRING", ""));
				//
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("USERAGENTINT", 0);
                spe.putString("USERAGENTSTRING", "Mobil");
				spe.putInt("USERAGENTCHANGE", 0);
                spe.apply();
				uaTextView.setText(""+sp.getString("USERAGENTSTRING", ""));
				//
				uacheckItemValue = 0;
				uacheckItemString = "Mobil";
				dialog.cancel();
				//uaLayout();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("USERAGENTCHANGE", 0) == 1) {
					findIntUserAgent();
					uacheckItemString = ""+sp.getString("USERAGENTSTRING", "")+"";
					uaTextView.setText(""+sp.getString("USERAGENTSTRING", ""));
				}
				else {
					uacheckItemValue = 0;
					uacheckItemString ="Mobil";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	// atLayout AlertDialog
	private void atLayout() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Uygulama Teması seçiniz");
		// Add a radio button list
		String[] at = {"Aydınlık Tema", "Karanlık Tema"};
		int checkedItem = atcheckItemValue; // Aydınlık Tema
		builder.setSingleChoiceItems(at, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Aydınlık Tema
					    atcheckItemValue = 0;
						atcheckItemString = "Aydınlık Tema";
					    //
						break;
					case 1: // Karanlık Tema
					    atcheckItemValue = 1;
						atcheckItemString = "Karanlık Tema";
					    //
						break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("APPTHEMEINT", atcheckItemValue);
                spe.putString("APPTHEMESTRING", ""+atcheckItemString+"");
				spe.putInt("APPTHEMECHANGE", 1);
                spe.apply();
				atTextView.setText(""+sp.getString("APPTHEMESTRING", ""));
				//
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("APPTHEMEINT", 0);
                spe.putString("APPTHEMESTRING", "Aydınlık Tema");
				spe.putInt("APPTHEMECHANGE", 0);
                spe.apply();
				atTextView.setText(""+sp.getString("APPTHEMESTRING", ""));
				//
				atcheckItemValue = 0;
				atcheckItemString = "Aydınlık Tema";
				dialog.cancel();
				//atLayout();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("APPTHEMECHANGE", 0) == 1) {
					findIntAppTheme();
					atcheckItemString = ""+sp.getString("APPTHEMESTRING", "")+"";
					atTextView.setText(""+sp.getString("APPTHEMESTRING", ""));
				}
				else {
					atcheckItemValue = 0;
					atcheckItemString ="Aydınlık Tema";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	// alLayout AlertDialog
	private void alLayout() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Uygulama Dili seçiniz");
		// Add a radio button list
		String[] al = {"Afrikaans", "Arabic", "Basque", "Bengali", "Burmese", "Catalan", "Simplified Chinese", "Traditional Chinese (Hong Kong)", "Traditional Chinese (Taiwan)", "Croatian", "Czech", "Danish", "Dutch", "English", "Finnish", "Filipino", "French", "German", "Greek", "Hebrew", "Hindi", "Hungarian", "Indonesian", "Italian", "Japanese", "Kannada", "Korean", "Malayalam", "Nepali", "Norwegian", "Oriya", "Persian", "Polish", "Portuguese (Brazil)", "Portuguese (Portugal)", "Romanian", "Russian", "Serbian", "Slovak", "Spanish", "Spanish (Latin America)", "Swedish", "Tamil", "Telugu", "Thai", "Turkish", "Ukrainian", "Urdu", "Vietnamese"};
		int checkedItem = alcheckItemValue; // Turkish
		builder.setSingleChoiceItems(al, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Afrikaans
						alcheckItemValue = 0;
						alcheckItemString = "Afrikaans";
						//
						break;
					case 1: // Arabic
						alcheckItemValue = 1;
						alcheckItemString = "Arabic";
						//
						break;
					case 2: // Basque
						alcheckItemValue = 2;
						alcheckItemString = "Basque";
						//
						break;
					case 3: // Bengali
						alcheckItemValue = 3;
						alcheckItemString = "Bengali";
						//
						break;
					case 4: // Burmese
						alcheckItemValue = 4;
						alcheckItemString = "Burmese";
						//
						break;
					case 5: // Catalan
						alcheckItemValue = 5;
						alcheckItemString = "Catalan";
						//
						break;
					case 6: // Simplified Chinese
						alcheckItemValue = 6;
						alcheckItemString = "Simplified Chinese";
						//
						break;
					case 7: // Traditional Chinese (Hong Kong)
						alcheckItemValue = 7;
						alcheckItemString = "Traditional Chinese (Hong Kong)";
						//
						break;
					case 8: // Traditional Chinese (Taiwan)
						alcheckItemValue = 8;
						alcheckItemString = "Traditional Chinese (Taiwan)";
						//
						break;
					case 9: // Croatian
						alcheckItemValue = 9;
						alcheckItemString = "Croatian";
						//
						break;
					case 10: // Czech
						alcheckItemValue = 10;
						alcheckItemString = "Czech";
						//
						break;
					case 11: // Danish
						alcheckItemValue = 11;
						alcheckItemString = "Danish";
						//
						break;
					case 12: // Dutch
						alcheckItemValue = 12;
						alcheckItemString = "Dutch";
						//
						break;
					case 13: // English
						alcheckItemValue = 13;
						alcheckItemString = "English";
						//
						break;
					case 14: // Finnish
						alcheckItemValue = 14;
						alcheckItemString = "Finnish";
						//
						break;
					case 15: // Filipino
						alcheckItemValue = 15;
						alcheckItemString = "Filipino";
						//
						break;
					case 16: // French
						alcheckItemValue = 16;
						alcheckItemString = "French";
						//
						break;
					case 17: // German
						alcheckItemValue = 17;
						alcheckItemString = "German";
						//
						break;
					case 18: // Greek
						alcheckItemValue = 18;
						alcheckItemString = "Greek";
						//
						break;
					case 19: // Hebrew
						alcheckItemValue = 19;
						alcheckItemString = "Hebrew";
						//
						break;
					case 20: // Hindi
						alcheckItemValue = 20;
						alcheckItemString = "Hindi";
						//
						break;
					case 21: // Hungarian
						alcheckItemValue = 21;
						alcheckItemString = "Hungarian";
						//
						break;
					case 22: // Indonesian
						alcheckItemValue = 22;
						alcheckItemString = "Indonesian";
						//
						break;
					case 23: // Italian
						alcheckItemValue = 23;
						alcheckItemString = "Italian";
						//
						break;
					case 24: // Japanese
						alcheckItemValue = 24;
						alcheckItemString = "Japanese";
						//
						break;
					case 25: // Kannada
						alcheckItemValue = 25;
						alcheckItemString = "Kannada";
						//
						break;
					case 26: // Korean
						alcheckItemValue = 26;
						alcheckItemString = "Korean";
						//
						break;
					case 27: // Malayalam
						alcheckItemValue = 27;
						alcheckItemString = "Malayalam";
						//
						break;
					case 28: // Nepali
						alcheckItemValue = 28;
						alcheckItemString = "Nepali";
						//
						break;
					case 29: // Norwegian
						alcheckItemValue = 29;
						alcheckItemString = "Norwegian";
						//
						break;
					case 30: // Oriya
						alcheckItemValue = 30;
						alcheckItemString = "Oriya";
						//
						break;
					case 31: // Persian
						alcheckItemValue = 31;
						alcheckItemString = "Persian";
						//
						break;
					case 32: // Polish
						alcheckItemValue = 32;
						alcheckItemString = "Polish";
						//
						break;
					case 33: // Portuguese (Brazil)
						alcheckItemValue = 33;
						alcheckItemString = "Portuguese (Brazil)";
						//
						break;
					case 34: // Portuguese (Portugal)
						alcheckItemValue = 34;
						alcheckItemString = "Portuguese (Portugal)";
						//
						break;
					case 35: // Romanian
						alcheckItemValue = 35;
						alcheckItemString = "Romanian";
						//
						break;
					case 36: // Russian
						alcheckItemValue = 36;
						alcheckItemString = "Russian";
						//
						break;
					case 37: // Serbian
						alcheckItemValue = 37;
						alcheckItemString = "Serbian";
						//
						break;
					case 38: // Slovak
						alcheckItemValue = 38;
						alcheckItemString = "Slovak";
						//
						break;
					case 39: // Spanish
						alcheckItemValue = 39;
						alcheckItemString = "Spanish";
						//
						break;
					case 40: // Spanish (Latin America)
						alcheckItemValue = 40;
						alcheckItemString = "Spanish (Latin America)";
						//
						break;
					case 41: // Swedish
						alcheckItemValue = 41;
						alcheckItemString = "Swedish";
						//
						break;
					case 42: // Tamil
						alcheckItemValue = 42;
						alcheckItemString = "Tamil";
						//
						break;
					case 43: // Telugu
						alcheckItemValue = 43;
						alcheckItemString = "Telugu";
						//
						break;
					case 44: // Thai
						alcheckItemValue = 44;
						alcheckItemString = "Thai";
						//
						break;
					case 45: // Turkish
						alcheckItemValue = 45;
						alcheckItemString = "Turkish";
						//
						break;
					case 46: // Ukrainian
						alcheckItemValue = 46;
						alcheckItemString = "Ukrainian";
						//
						break;
					case 47: // Urdu
						alcheckItemValue = 47;
						alcheckItemString = "Urdu";
						//
						break;
					case 48: // Vietnamese
						alcheckItemValue = 48;
						alcheckItemString = "Vietnamese";
						//
						break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
			    spe.putInt("APPLANGINT", alcheckItemValue);
                spe.putString("APPLANGSTRING", ""+alcheckItemString+"");
			    spe.putInt("APPLANGCHANGE", 1);
                spe.apply();
				alTextView.setText(""+sp.getString("APPLANGSTRING", ""));
			    //
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("APPLANGINT", 45);
                spe.putString("APPLANGSTRING", "Turkish");
				spe.putInt("APPLANGCHANGE", 0);
                spe.apply();
				alTextView.setText(""+sp.getString("APPLANGSTRING", ""));
				//
				alcheckItemValue = 45;
				atcheckItemString = "Turkish";
				dialog.cancel();
				//alLayout();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("APPLANGCHANGE", 0) == 1) {
					findIntAppLang();
					alcheckItemString = ""+sp.getString("APPLANGSTRING", "")+"";
					alTextView.setText(""+sp.getString("APPLANGSTRING", ""));
				}
				else {
					alcheckItemValue = 45;
					alcheckItemString ="Turkish";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	// langLTV AlertDialog
	private void langLTV() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Şu dilden çevir");
		// Add a radio button list
		String[] langltv = {"Turkish", "English"};
		int checkedItem = langltvcheckItemValue; // Turkish
		builder.setSingleChoiceItems(langltv, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Turkish
					    langltvcheckItemValue = 0;
						langltvcheckItemString = "Turkish";
					    //
						break;
					case 1: // English
					    langltvcheckItemValue = 1;
						langltvcheckItemString = "English";
					    //
						break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				langRTV();
				//
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
			    spe.putInt("LANGLTVINT", langltvcheckItemValue);
                spe.putString("LANGLTVSTRING", ""+langltvcheckItemString+"");
			    spe.putInt("LANGLTVCHANGE", 1);
                spe.apply();
				langLTV.setText(""+sp.getString("LANGLTVSTRING", ""));
			    //
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("LANGLTVINT", 45);
                spe.putString("LANGLTVSTRING", "Turkish");
				spe.putInt("LANGLTVCHANGE", 0);
                spe.apply();
				langLTV.setText(""+sp.getString("LANGLTVSTRING", ""));
				//
				langltvcheckItemValue = 0;
				langltvcheckItemString = "Turkish";
				dialog.cancel();
				langLTV();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("LANGLTVCHANGE", 0) == 1) {
					findIntLangLTV();
					langltvcheckItemString = ""+sp.getString("LANGLTVSTRING", "")+"";
					langLTV.setText(""+sp.getString("LANGLTVSTRING", ""));
				}
				else {
					langltvcheckItemValue = 0;
					langltvcheckItemString ="Turkish";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
		dialog.setCanceledOnTouchOutside(false);
		dialog.setCancelable(false);
	}
	
	// langRTV AlertDialog
	private void langRTV() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Şu dile çevir");
		// Add a radio button list
		String[] langrtv = {"Turkish", "English"};
		int checkedItem = langrtvcheckItemValue; // English
		builder.setSingleChoiceItems(langrtv, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Turkish
					    langrtvcheckItemValue = 0;
						langrtvcheckItemString = "Turkish";
					    //
						break;
					case 1: // English
					    langrtvcheckItemValue = 1;
						langrtvcheckItemString = "English";
					    //
						break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
			    spe.putInt("LANGRTVINT", langrtvcheckItemValue);
                spe.putString("LANGRTVSTRING", ""+langrtvcheckItemString+"");
			    spe.putInt("LANGRTVCHANGE", 1);
                spe.apply();
				langRTV.setText(""+sp.getString("LANGRTVSTRING", ""));
			    //
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("LANGRTVINT", 1);
                spe.putString("LANGRTVSTRING", "English");
				spe.putInt("LANGRTVCHANGE", 0);
                spe.apply();
				langRTV.setText(""+sp.getString("LANGRTVSTRING", ""));
				//
				langrtvcheckItemValue = 1;
				langrtvcheckItemString = "English";
				dialog.cancel();
				langRTV();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("LANGRTVCHANGE", 0) == 1) {
					findIntLangRTV();
					langrtvcheckItemString = ""+sp.getString("LANGRTVSTRING", "")+"";
					langRTV.setText(""+sp.getString("LANGRTVSTRING", ""));
				}
				else {
					langrtvcheckItemValue = 1;
					langrtvcheckItemString ="English";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
		dialog.setCanceledOnTouchOutside(false);
		dialog.setCancelable(false);
	}
	
	// sttlLayout AlertDialog
	private void sttlLayout() {
		// Setup the alert builder
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle("Şu dili algıla");
		// Add a radio button list
		String[] sttl = {"Turkish", "English"};
		int checkedItem = sttlcheckItemValue; // Turkish
		builder.setSingleChoiceItems(sttl, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User checked an item
				switch (which) {
					case 0: // Turkish
					    sttlcheckItemValue = 0;
						sttlcheckItemString = "Turkish";
					    //
						break;
					case 1: // English
					    sttlcheckItemValue = 1;
						sttlcheckItemString = "English";
					    //
						break;
				}
			}
		});
		// Add - Uygula and İptal - buttons
		builder.setPositiveButton("Uygula", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
			    spe.putInt("STTLANGINT", sttlcheckItemValue);
                spe.putString("STTLANGSTRING", ""+sttlcheckItemString+"");
			    spe.putInt("STTLANGCHANGE", 1);
                spe.apply();
				sttlTextView.setText(""+sp.getString("STTLANGSTRING", ""));
			    //
			}
		});
		builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				spe.putInt("STTLANGINT", 0);
                spe.putString("STTLANGSTRING", "Turkish");
				spe.putInt("STTLANGCHANGE", 0);
                spe.apply();
				sttlTextView.setText(""+sp.getString("STTLANGSTRING", ""));
				//
				sttlcheckItemValue = 0;
				sttlcheckItemString = "Turkish";
				dialog.cancel();
				//sttlLayout();
			}
		});
		builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// User clicked OK
				SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
				SharedPreferences.Editor spe = sp.edit();
				//
				if (sp.getInt("STTLANGCHANGE", 0) == 1) {
					findIntSpeakToTextLang();
					sttlcheckItemString = ""+sp.getString("STTLANGSTRING", "")+"";
					sttlTextView.setText(""+sp.getString("STTLANGSTRING", ""));
				}
				else {
					sttlcheckItemValue = 0;
					sttlcheckItemString ="Turkish";
				}
				//
				dialog.cancel();
			}
		});
		// Create and show the alert dialog
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	// aaLayout AboutPage
	private void aaLayout() {
		onCreateII(null);
		aboutpage = true;
	}
	
	// ppLayout AlertDialog
	private void ppLayout() {
	    // Creating alert dialog with one button
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this); 
		alertDialog.setTitle("Gizlilik Politikası");
		WebView pwv = new WebView(this);
	    pwv.loadUrl("file:///android_asset/privacypolicy_tr.html");
		pwv.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// Normal content, open
				if (url == null) {
					view.loadUrl(url);
					return true;
				}
				// Search for Third-Party apps
				try {
					// Asks user，search after permission 
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(intent);
					return true;
				} catch (Exception e) {
					return true;
				}
			}
		});
		alertDialog.setView(pwv);
		// Setting negative "Kapat" button
		alertDialog.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
			    // Write your code here to execute after dialog
				dialog.cancel();
			}
		});
		// closed
        // Showing alert message
		alertDialog.show();
	}
	
	// ddoLayout GoLink
	private void ddoLayout() {
		String link1 = "https://www.buymeacoffee.com/thekocanl";
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link1));
		startActivity(intent);
	}
	
	// sfLayout GoSendMail
	private void sfLayout() {
		String mail1 = "mailto:thekocanl@mail.com";
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mail1));
		startActivity(intent);
	}
	
	// onCreateII
	private void onCreateII(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.xml.aboutpage);
		
		// backPage FindId
		backPage = findViewById(R.id.backPage);
		// aaLayoutLink FindId
		aaLayoutLink = findViewById(R.id.aaLayoutLink);
		// aaLayout1 FindId
		aaLayout1 = findViewById(R.id.aaLayout1);
		// aaLayout2 FindId
		aaLayout2= findViewById(R.id.aaLayout2);
		// aaLayout3 FindId
		aaLayout3 = findViewById(R.id.aaLayout3);
		
		// backPage OnClick
		backPage.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));
				aboutpage = false;
			}
		});
		
		// aaLayoutLink OnClick
		aaLayoutLink.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				String aalayoutlink = "https://github.com/thekocanlhk/TawBrowser";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(aalayoutlink));
				startActivity(intent);
			}
		});
		
		// aaLayout1 OnClick
		aaLayout1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				aaLayoutTitle = "Değişiklik günlüğü";
				aaLayoutUrl = "file:///android_asset/changelog_tr.html";
				aaLayoutAD();
			}
		});
		
		// aaLayout2 OnClick
		aaLayout2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				aaLayoutTitle = "Katkıda bulunanlar";
				aaLayoutUrl = "file:///android_asset/contributors_tr.html";
				aaLayoutAD();
			}
		});
		
		// aaLayout3 OnClick
		aaLayout3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				//
				aaLayoutTitle = "Diğer lisanslar";
				aaLayoutUrl = "file:///android_asset/otherlicenses_tr.html";
				aaLayoutAD();
			}
		});
	}
	
	// aaLayout AlertDialog
	private void aaLayoutAD() {
	    // Creating alert dialog with one button
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this); 
		alertDialog.setTitle(""+aaLayoutTitle);
		WebView pwv = new WebView(this);
	    pwv.loadUrl(""+aaLayoutUrl);
		pwv.setWebViewClient(new WebViewClient() {
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					// Normal content, open
					if (url == null) {
						view.loadUrl(url);
						return true;
					}
					// Search for Third-Party apps
					try {
						// Asks user，search after permission 
						Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
						startActivity(intent);
						return true;
					} catch (Exception e) {
						return true;
					}
				}
			});
		alertDialog.setView(pwv);
		// Setting negative "Kapat" button
		alertDialog.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int id) {
					// Write your code here to execute after dialog
					dialog.cancel();
				}
			});
		// closed
        // Showing alert message
		alertDialog.show();
	}
	// onCreateII End
	
	// Back
	@Override
    public void onBackPressed() {
		if(aboutpage == true) {
		    startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));
			aboutpage = false;
		}
		else {
			startActivity(new Intent(SettingsActivity.this, WebActivity.class));
		}
	}	
}
