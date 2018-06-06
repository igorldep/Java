class Level1Exception extends Exception{ }

class Level2Exception extends Level1Exception{ }

class Level3Exception extends Level2Exception{ }

class Test{
	public static voidmain(Stringargs[]){
		inta, b, c, d, f, g, x;
		a = b = c = d = f = g = 0;
		x = Integer . parseInt(args[0]);
		try {
			try {
				switch (x) {
				case 0:
					throw new Level1Exception();
				case 1:
					throw new Level2Exception();
				case 2:
					throw new Level3Exception();
				case 3:
					throw new Exception();
				}

				a++;
			}

			catch(Level2Exceptione) {
				b++;
			}

			finally {
				c++;
			}
		}

		catch(Level1Exceptione) {
			d++;
		}

		catch(Exceptione) {
			f++;
		}

		finally {
			g++;
		}

		System.out.print(a + "," + b + "," + c + "," + d + "," + f + "," + g);

	}
}
