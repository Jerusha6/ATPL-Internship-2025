let currentIndex = 0;
const slides = document.querySelectorAll(".slide");
const slider = document.getElementById("slider");
let autoPlayInterval = null;

// Show slide by index
function showSlide(index) {
  slides.forEach((slide, i) => {
    slide.classList.remove("active");
    if (i === index) slide.classList.add("active");
  });
}

// Go to next slide
function nextSlide() {
  currentIndex = (currentIndex + 1) % slides.length;
  showSlide(currentIndex);
}

// Go to previous slide
function prevSlide() {
  currentIndex = (currentIndex - 1 + slides.length) % slides.length;
  showSlide(currentIndex);
}

// Start autoplay
function startAutoPlay() {
  autoPlayInterval = setInterval(nextSlide, 3000);
}

// Stop autoplay
function stopAutoPlay() {
  clearInterval(autoPlayInterval);
}

// Pause on hover
slider.addEventListener("mouseenter", stopAutoPlay);
slider.addEventListener("mouseleave", startAutoPlay);

// Initial setup
showSlide(currentIndex);
startAutoPlay();
