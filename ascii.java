package flowcontrol;

import java.util.ArrayList;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		ArrayList<Integer> randGen = new ArrayList<>();
		int nextRand;
		Random rand = new Random();
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXXXOxxxxxxxxxxxxxxxxxxxxxOXXXXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXXX0x:''''''''''''''''''''';o0KKXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXKXOc,'''''''''''''''''''''''';oOXXKXNNNNNNNNNNNNNNNNNNNNNNNNNNNXNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNWWWMMMMMMMMM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXKX0o;'''''''''''''''''''''''''''';oOKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXXXXXNWWMMMMMM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMMMMMMWNXXKk:'''''''':odoooooooooooc,'''''''';:::::::ccccccccccccccccccccccccc:ccccccccc:::::::::::::::::::::::c::codx0KXXXNWMMMM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMMMMWNXXKOo,''''''';dXWWMMMMMMMMWWXKx:''''''''',loc,''',,',,,,coxxdoc;,,,,,:odddddd:,,,,cddddddl;''''',codddl;'''''''';cx0XXXNWMM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMMMWXXXKd;''''''',l0NMWWMMMMMMMWNXXKk:''''''''.cKWx,,,,,,,,,:kXX0O0XXx:,;,,ck0NMNKOl,,,,lOKNWX0x;''''cONXOOKNKo,''''''''':xKXXXWM\r\n" +
				"MMMMMMMMMMMMMMMMMMMMMMWNXXXOc,''''''';xNMMMMMMMMMMWNXXKOl,''''''''''cKWx,,,,,,,,;xWNd;,;xNNo,;,,;;:OM0c,;,,,,,,cKWk;,,,,';OMKc'';kWKc'''''''''',l0XKXW\r\n" +
				"MMMMMMMMMMMMMMMMMMMMWNXXX0d;''''''',l0WWWMMMMMMMMWNKXKd;'''''''''','cKWk:::;;,,,;dNNxc::kNXo;;;;;,:OM0c,,,,,,,,cKWk;,,',,;kWKl;;:OWK:.'''''''''''oKXKX\r\n" +
				"MMMMMMMMMMMMMMMMMMMWNXKKk:'''''''':ONWMMMMMMMMMWNXXKkc'''''''''','',cKWXKKOdc,,;;:xKXXKXXKd:;;;;;;:OW0c,;;;,,,,c0Wk;,,,,,,:kKXKKXXOl''''''''''''';xXXX\r\n" +
				"MMMMMMMMMMMMMMMMMWNXXXOl,''''''';dXWWWMMMMMMMWNXXXOo,''''''''''',,,,;coooolc:;;;;;;cldddlc;;;;;;;;;ldl:;;;,,,;,;loc,,,',,'',;cool:,'''''''''''''''oXXX\r\n" +
				"MMMMMMMMMMMMMMMWNXKXKd;''''''',cOWWWMMMMMMMMWNXXKx:'''''''''''',,,,,,,,,,;;;;;;;;;;;;:;,,,,,,,',,,,,,,;;;;;;;;,,,,''''''''''''''''''''''''''''''''oKXX\r\n" +
				"MMMMMMMMMMMMMMWNXXKkc'..''''';xNWMMMMMMMMMWNXXKkc,''''''''''',,,,,,,,,;;;;;;;;;;::::;;,'',:::::;;;;,.',,;;;;,,'''',:cloddxxdddoc;,''''''''''''''''oKXX\r\n" +
				"MMMMMMMMMMMMWNXXX0o;''''''',lKWMMMMMMMMMMWNKK0o;'''''''''''',,,,,,,,;;;;;;;;;;:::::;,'',lOXNXXXXXXKxc''',;,,'',:ok0NWWMMWMMMMMMWX0xc,'''''''''''''oKXX\r\n" +
				"MMMMMMMMMMMWXKXKx:''''''''ckNMMMMMMMMMMWNXXKx:''''''''''''',,,,,,,,;;;;;;;;;;:::::;''';xNMMMMMMMMWNX0c''','':d0NWMMMMMMMMMMMMMMMMMMN0o,'''''''''''oKXX\r\n" +
				"MMMMMMMMMWNXKKOl,''''''',dXWMMMMMMMMMWNXXKOl,'''''''''''',,,,,,,,,;;;;;;:;:::::::,'.,lKWMMMMMMMMMWNXO:.''':xXWWMMMMMMMMMMMMMMMMMMMMMMW0o,'''''''''oKXX\r\n" +
				"MMMMMMMMWXKXKd;''''''''cONWWWMMMMMMMWNXXX0oc::;,''''''''',,,,,,,,;;;;;;;;::::::;,'':kNMMMMMMMMMMMWXKk,'',lKWWMMMMMMMWNNNNNNWWMMMMMMMMWMNk:''''''''oKXX\r\n" +
				"MMMMMMMWXKKOl,''''''';xXWWWWWMMMMMMMWWWWWWNNNXK0kdc,'''''',,,,,,,;;;;;;:::::::,'.,oKWMWWMMMMMMMMMNXKo'.,dNMMMMMMWWNXXXK0kxxxxOXWMMMMMMWWNO:'''''''oKXX\r\n" +
				"MMMMMWNXXKx:''''''',l0WWMMMMMMMMMMMMMMMMMMMMMMMMMWNKxc,''',,,,,,;;;;;;;::::;;'''cONWWMWMMMMMMMMMMXX0c',dNMMMMMMWNXKKOoc;,''''':OWMMMMMMWNXx,''''''oKXX\r\n" +
				"MMMMWNKXKd,''''''';kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOc,''',,,;;;;;;;;::;,''';dXMMMMMMWNWMMMMMMWXXk;'cKMMMMMMWNXK0o,''''''''''lXMMMMMMMNXO:''''''oKXX\r\n" +
				"MMMWXXX0l,'''''''lKWMMMMMMMMMMMMMMMMWWWWWMMMMMMMMMMMMMMNkc'''',;;;;;;;;;,''.'cONMMMMMWNXNMMMMMMMNXKd,,xWMMMMMMNXXk:'''''''''''.cXMMMMMMMNX0c''''''oKXX\r\n" +
				"MMWNXX0l''''''',dXWWMMMMMMMMMMMWWNNNXXNXNNNWMMMMMMMMMMMWWXo,'',,;;;;;;,,'';lxNWWMMMMWXXXWMMMMMMMNX0l',OMMMMMMMNX0l'''''''''''',xWMMMMMMWXXO:''''''oKXX\r\n" +
				"MWNXX0l''''''.;xNMMWWMMMMMMMWNXXXK0Oxddooodk0XWMMMMMMMMMMWXd,'',,;;;;,'',l0WWMMMMMWNXXK0XMMMMMMWXXO:.;OMMMMMMMNXO:''''''''''',dNMMMMMMMNXXx,''''''oKXX\r\n" +
				"MNXXKd,'''''',xNMMMMMMMMMMWNXXKOxoc;;;;;;;;;;ckNMMMMMMMMMMNKo''',;;,''':kNWWMMMMMWXXKOldNMMMMMMWXKx,',xWMMMMMMWW0c''''''''',lONMMMMMMMNXX0c'''''''oKXX\r\n" +
				"WXXXk:'''''''oNMMMMMMMMMMNXKKOo:;;;;;;;;;;;;;;:OMMMMMMMMMMNXk:'',,,'',oKWMMMMMMWNXKKx:,xMMMMMMMNXKo''':0WMMMMMMMNOo:;,,;:lx0NWMMMMMMWNXXKo''''''''oKXX\r\n" +
				"NXXKo'''''''cKWWMMMMMMMMWXXKx:;;;;;;;;;;;;;;;;;xWMMMMMMMMMNX0c'''''':ONMMMMMMWWNXX0l,.;0MMMMMMWXX0c''''c0WMMMMMMMWWNKKKXNWWMWWMWMMMWNXX0o'''''''''oKXX\r\n" +
				"XKXO:'''''.'xWMMMMMMMMMWXXKd;;;;;;;;;;;;;;;;;;;xNWMMMMMMMMNXKl'''',dXWMMMMMMWNXXKx:'''cXMMMMMMWXKk;''''';xXWWMMMMMMMMMMMMMMMMMMWMMWNXK0l''''''''''oKXX\r\n" +
				"XKXk,'''''.;OMMMMMMMMMMWXKk:,;;;;;;;;;;;;;;;;,:0MMMMMMMMMMNX0c'''cONWMMMMMNXXXKOl,''''dWMMMMMMNXKo'''''''':xKWWWMMMMWWWMMMMMMMMMWNXKKk:'''''''''''oKXX\r\n" +
				"XXXd''''''':0MMMMMMMMMMWXKd;;;;;;;;;;;;;;;;;;:kNMMMMMMMMMWXXk:''lXMMWWMMMWWNNNXOxxxxxxKWMMMMMMWWN0xxxxxxdc,';okKXNNNNNWMMMMMMMMWXKX0o,''''''''''''oKXX\r\n" +
				"XXXd''''''':0MMMMMMMMMMMNKd;;;;;;;;;;;;;;;,;ckNMWMMMMMMMWNXKo''cKWMMMMMMMMMMMMMMWMMMWMMWMMMMMMMMMWMMMWWNXKx:'',;cooxKWWMMMMMMWNXKKk:''''''''''''''oKXX\r\n" +
				"XKXx,'''''.;OWMMMMMMMMMMWNkc;;;;;;;;;;;;;;ckXWWMMMMMMMMWNKXk;.;OWMMMMMMMMMMMMMMMMMMWWMMMMMMMMMMMMMMWNNXXKOl;'''''.;kNMMMMMMWNXXK0o,'''''''''''''''oKXX\r\n" +
				"XKXO:'''''''oNMMMMMMMMMMWWNOl:;;;;,,;;:ldOXWWWMMMMMMMMWNXXO:''dNMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNXXXKko;'''''',oKWWWMMMMWNXXKx:'''''''''''''''''oKXX\r\n" +
				"NXXKo''''''';kWMMMMMMMMMWWWWNKOkxxxkO0KNWMMMMMMMMMMMWWXXKk:'',dKNNNNNNNNNNNNNNNNNNNNNWMMMMMMMNXXXKK0kdc,''''''':ONMWWMWWMWXKKOl,''''''''''''''''''oKXX\r\n" +
				"WXXXOc''''''';kNMMMMMMMMMMMWWWWWMWWWMMMWMMMMMMMMMMMWXXXKd;''''':odxddxdddddddddddddd0WWMMMMMWXKOocc;''''''''';dKWMMMMMMWNXKKx;''''''''''''''''''''oKXX\r\n" +
				"MNXKKO:''''''',oKWMMMMMMMMMMWWMMMMMMMMMMMMMMMMMMWWNXXKkc,'''''''''''''''''''''''''',xWMMMMMMNXKo'.''',,,''',l0WWWMMMMMWXXKOl,'''''''''''''''''''''dKXX\r\n" +
				"MMWXKXOc'''''''';oKWMMMMMMMMMMMMMMMMMMMMMMMMMWWNXXX0xc,'''''''''''''''''''''''''''.;OMWMMMMMNX0c.'',,,,''';xNMMMMMMMWNXKKd;'''''''''''''''''''''.;kXKX\r\n" +
				"MMMNXXX0d;'''''''';oOXWWWWWWMMMMMMMMMMMWWWNNXXXK0ko:,'''''''''''''''',,,,,,,,,,,''.:0WWWWWWNXXk;'',,,''''c0WWWWWWWWNXXKkc,'''''''''''''''''''''',oKXKX\r\n" +
				"MMMMWXKKKkl,'''''''',:ok0XNNNNNNNNNNNNNXXXKK0kdl:,''''''''''''''''''''',,,,,,,,,''',ckKKKKKKK0d,''',,'''':x0KXXKXKKXK0d;''''''''''''''''''''''',l0XKXW\r\n" +
				"MMMMMWNXKXKkc,''''''''',;:lodxxkOOOOkkkxdolc;,''''''''''''''''''''''''''',,,,,,,''''',;:::::::,'''',,,'''',;cccccccc:;''''''''''''''''''''''',:xKXXXWM\r\n" +
				"MMMMMMMWNXXKKkl;'''''''''''''''',,,,,,''''''''''''''''''''''''''''''''''''''''',''''''''''''''''''',,,,,'''''''''''''''''''''''''''''''''',;lk0KXXNWMM\r\n" +
				"MMMMMMMMMWNXXXK0xl;,'.''''''''''''''''''''''''''''',:clcccccccccccccccccccccccclllllllllllllllllcclllllllccccccccccccccccccccccccccccclloxk0XXXXNWMMMM\r\n" +
				"MMMMMMMMMMMWWNXXXX0kdl:;,'''''''''''''''''''',;cloxOKXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXXXXXXNNWMMMMMM\r\n" +
				"MMMMMMMMMMMMMMWWNXXXXKK0OkdoollccccccccloodxkO0KKXXXXNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNWWMMMMMMMMMM\r\n" +
				"MMMMMMMMMMMMMMMMMMWWNNXXXXXXXXXKKKKKKKXXXXXXXXXXNNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		for (int i = 0; i < 6; i++) {
			int loopcontrol=0;
			while (loopcontrol!=1) {
				nextRand = rand.nextInt(5)+1;
				if (randGen.contains(nextRand)){
					loopcontrol=0;
				}
				else {
					randGen.add(nextRand);
					loopcontrol=1;
				}
			}

		}
		System.out.println(randGen);
	}
}
