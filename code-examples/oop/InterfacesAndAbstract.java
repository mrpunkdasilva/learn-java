public class InterfacesAndAbstract {
    // Interface
    public interface Playable {
        void play();
        void pause();
        void stop();
    }
    
    // Classe abstrata
    public abstract class MediaPlayer implements Playable {
        protected String fileName;
        protected boolean isPlaying;
        
        public MediaPlayer(String fileName) {
            this.fileName = fileName;
            this.isPlaying = false;
        }
        
        // Método concreto
        public void stop() {
            this.isPlaying = false;
            System.out.println("Stopping playback");
        }
        
        // Método abstrato
        public abstract void loadMedia();
    }
    
    // Implementação concreta
    public class AudioPlayer extends MediaPlayer {
        private int volume;
        
        public AudioPlayer(String fileName) {
            super(fileName);
            this.volume = 50;
        }
        
        @Override
        public void play() {
            loadMedia();
            isPlaying = true;
            System.out.println("Playing audio: " + fileName);
        }
        
        @Override
        public void pause() {
            isPlaying = false;
            System.out.println("Audio paused");
        }
        
        @Override
        public void loadMedia() {
            System.out.println("Loading audio file: " + fileName);
        }
    }
}