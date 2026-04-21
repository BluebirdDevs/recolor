That mod allows resourcepack creators to change the color of a hard coded minecraft value into any color they want. This allows them to work with other resourcepack without using core shaders.

Some examples are:
- XP text color
- Reloading textures background
- Item cooldowns
- Container text
- Experience orb colors
- Block outline
- Durability bar colors


## Changing Colors with a Resource Pack
In order to change the color of something, you find the corresponding entry and replace it with the value you want. You should only put the values you modify in your pack so packs below it can modify other ones without them interfering.

If there is something that you want to be added, create a feature request in the github.

### Data type
Accepts an array of ints [r, g, b] or [r, g, b, a] and a hex string "#rrggbb" or "#aarrggbb"

### Path
```
assets/recolor/colors.json
```
### Example Values

**colors.json**
```
{
  "xpText": "#34b7ff",
  "loadingScreenMonochrome": "#660f00b5",
  "containerTitle": [125, 175, 255],
  "loadingScreen": [0, 63, 93, 102]
}
```
1. "#rrggbb" format
2. "#aarrggbb" format
3. [r, g, b] format
4. [r, g, b, a] format