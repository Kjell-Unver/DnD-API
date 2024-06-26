# DnD-API

This is a Java API to store and access your characters for DnD or other tabletop games. Lets start with the front end.


## Home site
![alt text](https://github.com/Kjell-Unver/img/blob/main/DnD-Api-img/home-img.png?raw=true)

The home site is the index.html site. This site will function as your menue.






## Api endpoints

There are multiple Api endpoints. This will give you a quick overview over them. If you want more information, check out the [yml](https://github.com/Kjell-Unver/DnD-API/blob/main/docs/DnD-Characters.yml).

<br>
<br>
<br>


### getCharacter
>GET endpoint

http://localhost:8080/character/UUID

Will return a Json of all the details from a single character.
<br>
<br>
<br>

### getCharacters
>GET endpoint

http://localhost:8080/characters

Will return a list of all the characterss in the DB. Only "id", "name", "level" and "description" are given with this endpoint. This is data is designed to work well with a list of all characters in the front end.

<br>
<br>
<br>

### postCharacter
>POST endpoint

http://localhost:8080/character

Sending a POST request to the same endpoint as getCharacter will result in the creation of a new character. The api will generate a new UUID for this charcter and send it in the response message. Therefore no UUID is required in the POST request. The data needs to be transfered in the Json file format.




The posted Json needs to follow this formating:
```
{
  "name": "Frodo",
	"level": 1,
	"description": "The dwarf from TLOTR",
	"hp": {
		"curr_hp": 21,
		"max_hp": 24
	},
	"skills": {
		"strength": 11,
		"dexterity": 15,
		"constitution": 10,
		"intelligence": 14,
		"wisdom": 13,
		"charisma": 12
	},
	"inventory": {
		"weapon": {
			"weapon_value": 13,
			"weapon_desc": "Metal sword"
		},
		"armour": {
			"armour_class": 10,
			"armour_desc": "Old clothes"
		},
		"potion": null,
		"items": [
			{
				"name": "Rune book",
				"description": "A book of runes.",
				"value": 200
			}
		]
	}
}
```


