package org.primefaces.extensions.showcase.model.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * DOCUMENT_ME
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
public class AvailableThemes {

	private static AvailableThemes instance = null;

	public static AvailableThemes getInstance() {
		if (instance == null) {
			instance = new AvailableThemes();
		}

		return instance;
	}

	private HashMap<String, Theme> themesAsMap;
	private List<Theme> themes;

	private AvailableThemes() {
		themes = new ArrayList<Theme>();
		themes.add(new Theme("aristo", ""));
		themes.add(new Theme("black-tie", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_black_tie.png"));
		themes.add(new Theme("blitzer", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_blitzer.png"));
		themes.add(new Theme("bluesky", ""));
		themes.add(new Theme("casablanca", ""));
		themes.add(new Theme("cupertino", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_cupertino.png"));
		themes.add(new Theme("dark-hive", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_dark_hive.png"));
		themes.add(new Theme("dot-luv", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_dot_luv.png"));
		themes.add(new Theme("eggplant", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_eggplant.png"));
		themes.add(new Theme("excite-bike",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_excite_bike.png"));
		themes.add(new Theme("flick", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_flick.png"));
		themes.add(new Theme("glass-x", ""));
		themes.add(new Theme("hot-sneaks",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_hot_sneaks.png"));
		themes.add(new Theme("humanity", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_humanity.png"));
		themes.add(new Theme("le-frog", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_le_frog.png"));
		themes.add(new Theme("midnight", ""));
		themes.add(new Theme("mint-choc", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_mint_choco.png"));
		themes.add(new Theme("overcast", ""));
		themes.add(new Theme("pepper-grinder",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_pepper_grinder.png"));
		themes.add(new Theme("redmond", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_windoze.png"));
		themes.add(new Theme("rocket", ""));
		themes.add(new Theme("sam", ""));
		themes.add(new Theme("smoothness",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_smoothness.png"));
		themes.add(new Theme("south-street",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_south_street.png"));
		themes.add(new Theme("start", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_start_menu.png"));
		themes.add(new Theme("swanky-purse",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_swanky_purse.png"));
		themes.add(new Theme("trontastic",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_trontastic.png"));
		themes.add(new Theme("ui-darkness", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_ui_dark.png"));
		themes.add(new Theme("ui-lightness",
		                     "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_ui_light.png"));
		themes.add(new Theme("vader", "http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_black_matte.png"));

		themesAsMap = new HashMap<String, Theme>();
		for (final Theme theme : themes) {
			themesAsMap.put(theme.getName(), theme);
		}
	}

	public final List<Theme> getThemes() {
		return themes;
	}

	public Theme getThemeForName(final String name) {
		return themesAsMap.get(name);
	}
}
