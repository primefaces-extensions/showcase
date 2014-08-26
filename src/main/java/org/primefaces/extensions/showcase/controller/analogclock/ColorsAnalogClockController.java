package org.primefaces.extensions.showcase.controller.analogclock;

import org.primefaces.extensions.component.analogclock.model.AnalogClockColorModel;
import org.primefaces.extensions.component.analogclock.model.DefaultAnalogClockColorModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

@ManagedBean
@RequestScoped
public class ColorsAnalogClockController implements Serializable{

	private static final long serialVersionUID = -5427668306657486626L;

    private AnalogClockColorModel randomTheme = new DefaultAnalogClockColorModel();
    private AnalogClockColorModel customTheme = new DefaultAnalogClockColorModel();
    private Random random = new Random();

    public ColorsAnalogClockController() {

        customTheme.setBorder(Color.RED);
        customTheme.setFace(Color.DARK_GRAY);
        customTheme.setHourHand(Color.WHITE);
        customTheme.setHourSigns(Color.WHITE);
        customTheme.setMinuteHand(Color.WHITE);
        customTheme.setPin(Color.RED);
        customTheme.setSecondHand(Color.WHITE);

        randomTheme.setBorder(randomColor());
        randomTheme.setFace(randomColor());
        randomTheme.setHourHand(randomColor());
        randomTheme.setHourSigns(randomColor());
        randomTheme.setMinuteHand(randomColor());
        randomTheme.setPin(randomColor());
        randomTheme.setSecondHand(randomColor());

    }

    public AnalogClockColorModel getCustomTheme() {
        return customTheme;
    }

    public AnalogClockColorModel getRandomTheme() {
        return randomTheme;
    }

    private Color randomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

}
