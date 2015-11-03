# Howto create your own Metadata File for CM-Updater #

Just create an empty xxx.json File on your Computer.
> Currently the Format of the File must be the following:
```
{
    "MirrorList": [
        "http://n0rp.chemlab.org/android/",
        "http://n0rp.chemlab.org/android/experimental/",
        "http://android.phaseburn.net/mirrors/cyanogen/",
        "http://android.phaseburn.net/mirrors/cyanogen/experimental/",
        "http://cyanogen-updater.googlecode.com/files/"
    ],
    "UpdateList": [
        {
            "mod": "ADP1",
            "board": "trout",
            "type": "rom",
            "name": "CyanogenMod-3.9.7",
            "version": "3.9.7",
            "description": "",
            "branch": "X",
            "filename": "update-cm-3.9.7-signed.zip"
        },
        {
            "mod": "ADP1",
            "board": "trout",
            "type": "rom",
            "name": "CyanogenMod-3.9.6",
            "version": "3.9.6",
            "description": "",
            "branch": "X",
            "filename": "update-cm-3.9.6-signed.zip"
        }
    ]
}
```

# For ROM Updates #
  * Mirrorlist: Add your downloadurls here
  * UpdateList: Every new Update gets a entry here (the part within the `{ }`)
    1. **mod:** Always put ADP1 in here, so the old Versions (<2.0) of CM-Updater can read the Updates. You can also put a `*` in here
    1. **board:** The Phone for which the ROM was designed. Multiple boards possible. in Example: trout|sapphire will show this Update only to Dream and Sapphire Users. You can get the value from /system/build.prop Valuename: ro.product.board. This is only supported since Version 3 of the App. When you put a `*` in there, all board will be supported
    1. **type:** Must be "rom" for ROM Updates
    1. **name:** The Name of the Update that shows up in the Dropdownlist of available Updates in the App
    1. **version:**  The Version, the ro.modversion String gets compared to. When the User is running Cyanogen 4.0.1, the ro.modversion String will read CyanogenMod-4.0.1. We strip the Version from this String and compare it to the Version provided in the Metadata File. So this will show up as a Update on cm4.0.1, but not on 4.0.2, because the 4.0.2 would be a newer Version.
    1. **description:** Put in your Changelog here, each entry splitted by |. Attention: Please dont use " in your description, or you will break the JSON File
    1. **branch**: Must be X or S. X for experimental and S for Stable. When you put a X here, the Update will only show up, if the User enabled the "Show Experimental Builds" option
    1. **filename:** The filename of the File. The Update URL is created by randomly taking a mirror and append the Filename at the end. mirror + filename. So http://n0rp.chemlab.org/android/ + update-cm-3.9.7-signed.zip = http://n0rp.chemlab.org/android/update-cm-3.9.7-signed.zip. This is also the filename used, to store the Update in the cm-updates Folder.

# For Theme Updates #
## Please note: Theme Updates are only shown for your CURRENT Rom (NOT overrideable via Settings). So you cant mess up your System by flashing a Theme not designed for you ROM ##
  * Mirrorlist: Add your downloadurls here
  * UpdateList: Every new Update gets a entry here (the part within the `{ }`)
    1. **mod:** Put the ro.modversion from build.prop here, the Theme was made for. Example: CyanogenMod-4.1.1 (must be the Exact string). You can also put a `*` in here to support ALL mods. Multiple mods supported by splitting them by a | . Example: CyanogenMod-4.1.1|CyanogenMod-4.1 when cyanogen does a quick fix that doesnt affect your theme
    1. **board:** The Phone for which the Theme was designed. Multiple boards possible. in Example: trout|sapphire will show this Update only to Dream and Sapphire Users. You can get the value from /system/build.prop Valuename: ro.product.board. This is only supported since Version 3 of the App. You can also put a `*` here, to support all boards
    1. **type:** Must be "theme" for Theme Updates
    1. **name:** The Name of the Update, provided in the themes.theme File under /system/framework (see below)
    1. **version:**  The Version of the Update. This gets compared to the Version, that is currently Stored in the themes.theme File
    1. **description:** Put in your Changelog here, each entry splitted by |. Attention: Please dont use " in your description, or you will break the JSON File
    1. **branch**: Must be X or S. X for experimental and S for Stable. When you put a X here, the Update will only show up, if the User enabled the "Show Experimental Builds" option. So you can have Experimental Themeupdates ;)
    1. **filename:** The filename of the File. The Update URL is created by randomly taking a mirror and append the Filename at the end. mirror + filename. So http://n0rp.chemlab.org/android/ + update-cm-3.9.7-signed.zip = http://n0rp.chemlab.org/android/update-cm-3.9.7-signed.zip. This is also the filename used, to store the Update in the cm-updates Folder.


## ATTENTION: ##
You MUST have an md5sum File on your Server, thats named like the Filename, or the App will refuse the Download of the File.
Example:
Filename: http://n0rp.chemlab.org/android/update-cm-3.9.7-signed.zip
MD5File: http://n0rp.chemlab.org/android/update-cm-3.9.7-signed.zip.md5sum

The easiest way to give the Link to your own JSON to the Users is to use a 2D Barcode.
Here is a page to create one:
http://qrcode.kaywa.com/

The the user has to open Settings-->Update Server-->Scan QR URL, and te next Time he does a check now, your Updates will show up. At this Time you can only have 1 MetadataFile, so the User has to switch the URL each Time.

# themes.theme #
To get the updater working with your Theme, you have to create a File called themes.theme under /system/framework/ (you change this directory on each Theme so its no big deal)
The Content must be:

**ThemeName|Version**

The ThemeName must Match the "name" tag in the JSON File, and the Version is the Versionstring, the "version" from the JSON gets compared to.

You can now also put a `*` in it, or when the File does not exist, the App assumes a Wildcard. So you will be able to install Themes, even if there's no themes.theme file. But your Systems Mod Version must still match the "mod" Tag from the JSON, so you will not mess up your System by applying a Theme, thats not for your System.