package cmupdaterapp.customization;

public class Customization
{
	//The String from the build.prop before the Version
	public static final String RO_MOD_START_STRING = "CyanogenMod-";
	//Minimum Supported Version (So the User has to install google apps and so before)
	public static final String MIN_SUPPORTED_VERSION_STRING = RO_MOD_START_STRING + "4.1.99";
	//Updateinstructions for the min supported Version
	public static final String UPDATE_INSTRUCTIONS_URL = "http://www.simplehelp.net/2009/10/04/how-to-install-cyanogenmod-4-1-99-on-your-g1-android-phone/";
	//Data Firectory on SDCard
	public static final String EXTERNAL_DATA_DIRECTORY = "cmupdater/data";
	//MUST be the first package name.
	public static final String PACKAGE_FIRST_NAME = "cmupdaterapp";
	//Filename for Instance save
	public static final String STORED_STATE_FILENAME = "cmupdater.state";
	//Android Board type
	public static final String BOARD = "ro.product.board";
	//Name of the Current Rom
	public static final String SYS_PROP_MOD_VERSION = "ro.modversion";
}