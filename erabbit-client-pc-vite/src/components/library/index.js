import XtxSkeleton from "@/components/library/xtx-skeleton.vue";
import XtxCarousel from "@/components/library/xtx-carousel.vue";

export default {
  install(app) {
      app.component(XtxSkeleton.name, XtxSkeleton)
      app.component(XtxCarousel.name, XtxCarousel)
  }
}
