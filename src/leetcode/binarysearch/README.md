| lower bound     | goal                    | upper bound
+-----------------+-------------------------+--------------
|         Illegal | better            worse |
+-----------------+-------------------------+--------------


if (item[testpos] > goal)
{
  //  new best-so-far
  upperbound = testpos;
}
else
{
  lowerbound = testpos + 1;
}

Normally, half-open ranges are used - an inclusive lower bound and an exclusive upper bound.
Using this system, the item at the upper bound index is not in the search range (at least not now),
but it is the best-so-far solution. When you move the lower bound up,
you move it to testpos+1 (to exclude the item you just tested from the range).
When you move the upper bound down, you move it to testpos (the upper bound is exclusive anyway).