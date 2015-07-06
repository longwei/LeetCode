package leetcode.cleancode;

/**
 * Created by longwei on 7/5/15.
 */
public class Read4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private int read4(char[] buffer){
        return 4;
    }
    public int read(char[] dest_buf, int n) {
        char[] buffer = new char[4];
        int destBufferIndex = 0;
        boolean eof = false;
        while (!eof && destBufferIndex < n) {
            int sz = read4(buffer);
            if (sz < 4) eof = true;
            int write_bytes = Math.min(n - destBufferIndex, sz);
            System.arraycopy(buffer /* src */, 0 /* srcPos */,
                    dest_buf /* dest */, destBufferIndex /* destPos */, write_bytes /* length */);
            destBufferIndex += write_bytes;
        }
        return destBufferIndex;
    }

    //what if we could use read4 multiple time in one function?
    //edge case is that there is still partially left
    //and partially left buffer size may bigger than max,
    //so there could be partically left on already leftover...
    //after handling leftover buffer, the rest is same as old read
    //destBuffer   mBuffer  File

    //看看人家怎么做归纳的
    private char[] mBuffer = new char[4];
    private int mLeftoverSize = 0, mOffset = 0;


    public int readMemory(char[] destBuffer, int max){
        int destIndex = 0;
        boolean eof = false;
        while(!eof && destIndex < max){
            int sz = (mLeftoverSize > 0) ? mLeftoverSize : read4(mBuffer);
            if(mLeftoverSize == 0 && sz < 4) eof = true;
            int writeByte = Math.min(max - destIndex, sz);
            System.arraycopy(mBuffer, mOffset, destBuffer, destIndex, writeByte);
            mLeftoverSize = sz - writeByte;
            mOffset =( mLeftoverSize == 0 ? 0: (writeByte + 1) );
            destIndex += writeByte;
        }
        return destIndex;
    }
}
