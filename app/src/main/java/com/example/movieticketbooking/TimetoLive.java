package com.example.movieticketbooking;

class TimetoLive extends Thread implements Runnable {


    public void removeKey(String name, long time) {
        //removes key after TTL expires
        final String na = name;
        final long t = time;
        final DBAdapter dba = new DBAdapter(adminDelete.java);
        dba.open();
        Thread keyTimetoLive = new Thread()                     //a new thread is created for every key with TTL, which runs concurrently in the background
        {
            @Override
            public void run()
            {

                while((System.currentTimeMillis()-3600000)!=t)
                {
                    //runs till the specified TTL value in System clock
                }
                dba.deleteMovie(na);     //removes the key from dataStore
            }
        };
        keyTimetoLive.start();
        dba.close();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
