1. Open Picture.java and look for the method getPixels2D. Is it there?
The method getPixels2D is not actually implemented in the file but it is being called within the file.

2. Open SimplePicture.java and look for the method getPixels2D. Is it there?
The method getPixels2D is in the file.

3. Does the following code compile?
  DigitalPicture p = new DigitalPicture();
No

4. Assuming that a no-argument constructor exists for SimplePicture, would the following code compile?
  DigitalPicture p = new SimplePicture();
Yes

5. Assuming that a no-argument constructor exists for Picture, does the following code compile?
  DigitalPicture p = new Picture();
Yes

6. Assuming that a no-argument constructor exists for Picture, does the following code compile?
  SimplePicture p = new Picture();
Yes

7. Assuming that a no-argument constructor exists for SimplePicture, does the following code compile?
  Picture p = new SimplePicture();
No

------------------------------------------------------------------
ACTIVITY 7:

1. How many times would the body of this nested for loop execute?
  for (int row = 7; row < 17; row++)
  for (int col = 6; col < 15; col++)
90

2. How many times would the body of this nested for loop execute?
  for (int row = 5; row <= 11; row++)
  for (int col = 3; col <= 18; col++)
112
