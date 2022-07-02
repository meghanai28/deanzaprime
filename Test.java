public class Test {

	public static void main (String [] args)
	{
		ArrayPrime test = new ArrayPrime();
		int [] a = {871};
		
		System.out.println(test.IsArrayPrimeIter(a,a.length));
		System.out.println(test.IsArrayPrimeRecur(a,a.length));
	}
	
	public boolean IsArrayPrimeIter(int [] arr, int size)
	{
		
		for(int i =0; i<size; i++)  // iterate through each element in loop
		{
			if( arr[i] % 2 == 0 || arr[i] == 1) // if the arr[i] is either 1 or divisible by 2, we know its not a prime number. so return false
			{
				return false;
			}
			
			for(int j=3; j<=Math.sqrt(arr[i]); j+=2) // since we only enter this loop if arr[2] is not divisble by 2, we can iterate through odd numbers.
      // we only have to go up to the sqrt of arr[i], since if a number is prime, atleast one divisor will be less than sqrt(arr[i]).
			{
				if(arr[i]%j == 0) // check if number is divisible by using modulo
				{
					return false; 
				}
			}
		}
		return true; // if the for loops all exit without any returns, return true.
	}
	
	public boolean IsArrayPrimeRecur(int[] arr, int size)
	{
		
		if(size == 0) // if the size is 0, that means we found that all numbers are prime. (i.e: this is base case)
		{
			return true;
		}
		
		if(!isPrimeRecur(arr[size-1], 3)) // check if number is a prime number, by using helper method PrimeRecur. (divisor starts at 3 so we can optmize our code.)
		{
			return false;
		}
		
		return IsArrayPrimeRecur(arr, size-1); // recursively call our method again, with size -1, so that we can get the next value in the array.
		
		
	}
	
	public boolean isPrimeRecur (int num, int divisor)
	{
		
		if(num<=2) // if the number is 2 or 1, return true if number is 2, and false if number is 1.
		{
			return !(num==1);
		}
		
		if(num%divisor == 0 || num%2 == 0 ) // check is number is divisible by divisor or 2. If number is divisible by 2, we return false. if it isn't we only have check
    // if the value is divisble by odd numbers. 
		{
			return false;
		}
		
		if(divisor > Math.sqrt(num)) // if number the divisor is incremented to the point it is greater than Math.sqrt(num) that means the number is a prime number. so we return true.
		{
			return true;
		}
		
		return isPrimeRecur(num, divisor +2); // recursively call our method, with the divisor +2, since we only reach this step if the number is not divisble by 2, which means
    // we only have to check if number is divisble by odd numbers.
	}
}