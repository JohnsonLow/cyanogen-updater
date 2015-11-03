<br /><br /><br />

---

# **This project is no longer maintained** #

---

<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
# If you're looking for Themeservers, click here: #
http://forum.xda-developers.com/forumdisplay.php?f=450
# If you like my work, buy me a beer #
**USD:** https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=8249540

**EUR:** https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=7928917

# CM-Updater 5.0.1 is out #
  * Now with N1 support ;)
  * Update.json is now hosted on github

# CM-Updater 5.0.0 is out #
  * Changed Update Folder so theres only one Directory on SDCard (new: /sdcard/cmupdater/updates)
  * Screenshots for Themes. They are now stored in an Database on SD-Card(reason for the update folder change)
  * Screenshots are only downloaded, if the Modified HTTP Header has changed, otherwise the cached image is taken
  * And some other freaky Screenshot Things
  * When there is an HTTP-Exception on Downloading a Theme.json, the Updatecheck will continue with the other Themeservers
  * More Menu Items in the ThemeServer list to make live easier with Featured ThemeServers
  * Version Compare is now working again correctly (hopefully)
  * Reduced the Package Size (about 200kb) by using NinePatch Drawables and Changing the PNGs from RGB to Indexed
  * There is now a check if theres enough space available on SDCard before downloading the Update
  * Downloads are now resumeable (server hosting the update.zip must support it)
  * Changed Service Implementation to the AIDL Interface
  * Services are now running in the Background
  * Made it easier for other devs to use the updater for their roms (see wiki)
  * Featured Theme Servers are now marked in Yellow
  * Theme Server List is now sorted alphabetically
  * Incremental Update Support, till Cyanogen hacks the OTA Updater ;)
  * Screenshot Support can now be disabled on Build Time(for other roms).
  * Debug Output is now disabled by Default to make the App faster. You can reenable it in Advanced Settings

# CM-Updater 4.5.2 is out #
  * Fixed a Bug in UpdateCheck

# CM-Updater 4.5.1 is out #
  * Updated Translations (now in UTF8)
  * Fixed a Bug in UpdateCheck
  * Reset the update.json File back to default for all the people that switched to beta.json

# CM-Updater 4.5 is out #
  * Updated Translations
  * Major Code cleanup. Hope i made no Mistakes ;)
  * Theme Version is now Displayed in the Dropdownlist. So if you changed your Theme name to contain the Version name, change it back, or the Version is Displayed twice ;)
  * Theme Version is now String Compared, so you can also have a Theme Version like `1.4.5-r3`. But remember: `1.4.5-r3` is "greater" and newer than `1.4.5`
  * When you cancel the download, the half downloaded File gets deleted
  * Progress dialog when applying an existing update without md5sum is now disabled
  * new logcat command is `adb logcat cmupdater:V *:S` Now windows user friendly ;)
  * Download is not completly canceled when you hit the cancel button
  * Now you can add Multiple Theme Servers (sooooooooo much work)
  * New UpdateCheck mechanism. It will only notify you on NEW updates. So you can use the automatic UpdateCheck again ;)
  * Toasts on MD5verification failure or other downloading Problems
  * Now you can update the Theme Servers with a List of Featured Theme Servers
  * When you disabled a Featured Theme, and the URL changes (after updateing the Theme Servers again) the disabled state remains
  * Remove the scan update.zip qr menu item, cause people get confused about it ;)
  * When coming from an older cyanogen rom, you get update instructions

# CM-Updater 4.1 is out #
  * Fixed Bug when changing orientation while Barcodescanning
  * Fixed Bug with MD5SUM to Pad the String to 32chars
  * UpdateFolder can now be changed (i think its beta ;) )

# CM-Updater 4.0 is out #
  * Support for Theme Developers to provide their updates also via the updater
  * Progressdialog on Updatechecking will now go away on errors
  * Mod Version in Title Bar
  * Updated Translations
  * Seperate JSON File for Themes. Also via Barcodescanner
  * URL Checker when entering new UpdateServer urls, so there will be no Exceptions
  * themes.theme File configurable via Advanced Properties
  * ALternative md5sum Method, so the md5sum binary is not needed
  * No Updatecheck Exceuted --> Last updatecheck was printed as Mindate. its now a String.
  * When no themes.theme File is present, a Wildcard is used for Updates, so you can install them, without having this File. Your SystemROM still must match the Property in the JSON so you will not mess up your system. You can also put a `*` in the themes.theme File. It has the same effect
  * New Structured Preferences Menu
  * Loading image is displayed while app is loading. No more black screen on starting
## Screenshots 4.0: ##
![http://cyanogen-updater.googlecode.com/files/1.png](http://cyanogen-updater.googlecode.com/files/1.png)
![http://cyanogen-updater.googlecode.com/files/2.png](http://cyanogen-updater.googlecode.com/files/2.png)
![http://cyanogen-updater.googlecode.com/files/4.png](http://cyanogen-updater.googlecode.com/files/4.png)
![http://cyanogen-updater.googlecode.com/files/5.png](http://cyanogen-updater.googlecode.com/files/5.png)
![http://cyanogen-updater.googlecode.com/files/6.png](http://cyanogen-updater.googlecode.com/files/6.png)
![http://cyanogen-updater.googlecode.com/files/7.png](http://cyanogen-updater.googlecode.com/files/7.png)
![http://cyanogen-updater.googlecode.com/files/8.png](http://cyanogen-updater.googlecode.com/files/8.png)
![http://cyanogen-updater.googlecode.com/files/9.png](http://cyanogen-updater.googlecode.com/files/9.png)
![http://cyanogen-updater.googlecode.com/files/10.png](http://cyanogen-updater.googlecode.com/files/10.png)
![http://cyanogen-updater.googlecode.com/files/11.png](http://cyanogen-updater.googlecode.com/files/11.png)
![http://cyanogen-updater.googlecode.com/files/12.png](http://cyanogen-updater.googlecode.com/files/12.png)
![http://cyanogen-updater.googlecode.com/files/13.png](http://cyanogen-updater.googlecode.com/files/13.png)
![http://cyanogen-updater.googlecode.com/files/14.png](http://cyanogen-updater.googlecode.com/files/14.png)
![http://cyanogen-updater.googlecode.com/files/15.png](http://cyanogen-updater.googlecode.com/files/15.png)
![http://cyanogen-updater.googlecode.com/files/16.png](http://cyanogen-updater.googlecode.com/files/16.png)
![http://cyanogen-updater.googlecode.com/files/17.png](http://cyanogen-updater.googlecode.com/files/17.png)

---


# CM-Updater 3.7 is out #
  * Changed the Changelogdialog Titles to App Changelog and Rom Changelog
  * UpdateCheck Notification is now removed, when you click on it to open the App
  * Downloadinfo in Notificationbar much more efficient (thanks zillode for the patch) and it will be displayed in minutes and seconds
  * Toast when Downloading Fails will now go away and not stay at the screen forever
  * Minor Bugfixes(You will not recognize them in the app)
  * There are now Icons representing Experimental and Stable in the List of available Updates. Thanks to Quintin for the initial work.
  * New/Updated Translations
  * Removed an unnecessary layout
  * Now with a cool Looking ViewFlipper to Change between the Layouts

# CM-Updater 3.6 is here #
  * Application Changelog via downloaded XML
  * Rom Changelog for selected ROM. Changelogbutton is only shown, when there is a description in the JSON file
  * Found Updates are now saved again, when closing the App
  * Updated German Translations
  * Updated Russian Translations

# CM-Updater 3.5 is here #
  * New Menu Icons and new Notificatiobaricon thanks Prash
  * Updated Russian Translation
  * Download Status in the Notification Bar and can run in Background
  * User is now notified via Toast that he has to uninstall the old Version
  * Now Stable/Experimental is shown next to each Update Entry
  * New Advanced Preferences, to play with the Update Speed of the Download Notifications. Please handle with care ;)

# CM-Updater 3.1.1 is here #
## <font color='red'>The App will Prompt you to uninstall any old Version. The dialog will pop up, till you uninstall the old Version ;)</font> ##
  * Changed the Package name, so we can put it on the Market
  * Old Version MUST be uninstalled to make the App start. So we can be sure that there will not be 2 cm-updaters and 2 backgroundservices on your system ;)
  * Korean Translation
  * Italian Translation
  * Removed unneeded code

# CM-Updater 3.0 is here(uninstall old Version first) #
  * Download should be cancelled correctly(no more downloading in the background)
  * Download will now be cancelled, if one of the front keys on the g1 are pressed
  * Download will be cancelled, when a menu is opened(Preferences, QR Scan,...)
  * Abbility to delete only the selected Update in the Update folder instead of the whole folder
  * Fixed the Translation Bugs that force closes (some strings will be in english)
  * User is redirected to Updater Chooser Layout after a fresh install(No metadatafile in cache) when there are Updates in the Update folder, so he can apply them through the app
  * Added a Check Now Button on the UpdateChooser Layout (point Above) if no metadatafile is cached (otherwise you have to da a menu --> check now ;) )
  * Orientation Changes in the Download View no longer cancels the download
  * New Item in JSON File to support the upcoming Cyanogen MyTouch Mod (board: board1|board2|board3...)
  * Ringtone Preferences will now work
  * Vibrate Setting for Notifications
  * Fixed Bug, that Found Updates are not shown in Dropdown List
  * now you can do an `adb logcat | grep "<CM-Updater>"` so see only our Output from the App
  * Last Update Check Date is now shown on GUI
  * If the update you're trying to download exists, the app will promp you to overwrite it or not
  * No more strechted Background on the updatechooser Layout when showing all Buttons
  * If no MD5SUM exists in the existing Update Folder, User is asked what to do before Applying
  * Check for Update in the App no longer closes it. Runs in a seperate Thread
  * New Landscape Wallpaper
  * Notifications can now be disabled at all. But when no Notifications are selected, no automated Updatechecking will be done
  * Changelog via Menu. This opens just the Browser and redirects to the Google Code Page. Internal Changelog programmed, but there are a few layout issues so it will probably in the next release.
  * Changes of the MetaData File URL now works immediatly

---


# Official cm-updater v2 is out #
  * Update check period can be set to manual
  * Metadata-File changed to JSON Format
  * Set the Location of the MetaData File via Preferences
  * The configurable Update Server has been improved. You can now update your update server URL by scanning a QR Code. Menu -> Configuration -> Update Server -> Scan Barcode
  * You can also now scan a QR code containing a direct link to Update zip (i.e. no need for a update server). Menu -> Scan QR URL
  * Ability to set Update Server URL via QR Code. And also a button to set it to default
  * MD5SUM removed from Metadata File. Its getting downloaded from the Server
  * Updates are now stored in the cm-updates Folder on SD and also get applied from there
  * Abbility to delete the whole UpdateFolder via the App
  * The "Existing update.zip found" replaced with a Dropdownlist of all updates in the cm-updates Folder, so the User can choose which one to apply
  * Updates are not renamed to update.zip. the original filename from the server is taken to store them in the new folder. So you can have multiple updates in the folder
  * A little Bit Connection cleanup on Mirror Changes
  * New Infos in DownloadDialog: Filename, Download Speed and Remaining Time
  * aTrackDog support
  * Russian, German, Italian, Dutch, French, Portuguese, Polish, Simplified Chinese and Spanish Translation

Cyanogen has a lot of work on his plate... stable and unstable roms and a recovery image to maintain....
on his TODO list for a while has been an OTA updater
lets do some work for him for a change, he has done so much for us already

basically...

modify jf-updater to make an updater for cyanogen's unstable roms

# V1.1 Available #

  * Added graphics by prash
  * Allow choice of showing experimental builds or just stable builds
  * Workaround for [Issue 1](https://code.google.com/p/cyanogen-updater/issues/detail?id=1) (see tracker)
  * Fix for Service not firing at startup
  * Lots of other changes that I can't remember...
  * Mainly just string fixes (better English, Capitalization, CM instead of JF)
  * Some minor UI enhancements (background, alignment)

# Find cyanogen-updater on the Market #
You can use your G1's barcode scanner to scan the image and find this app in the Android Market.

![http://underwaterterps.com/cmupdater/images/barcode.png](http://underwaterterps.com/cmupdater/images/barcode.png)
or have a look on Cyrket
http://www.cyrket.com/package/cmupdater.ui