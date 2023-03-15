import React from 'react'

export const loadImages = (imageFinder) => {

    const imageOjbect = {
        "Version1Notepad.png":require('../assets/Version1Notepad.png'),
        "Version1tshirt.png":require('../assets/Version1tshirt.png'),
        "Version1Bottle.png":require('../assets/Version1Bottle.png'),
        "Version1Mug.png":require('../assets/Version1Mug.png'),
        "Version1ToteBag.png":require("../assets/Version1ToteBag.png"),
        "Version1Backpack.png":require("../assets/Version1Backpack.png")
    }
  return imageOjbect[imageFinder]
}
