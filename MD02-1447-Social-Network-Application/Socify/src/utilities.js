const url = "https://reactdevcampapi.com/media/";

export const generateMediaUrl = mediaId => url + mediaId;
export const formatDate = date => {
    const formatted = new Date(date);
    return formatted.toLocaleString();
};


export const placeholder = "https://quaan.one/wp-content/uploads/2018/08/default-avatar.jpg";
export const coverPlaceholder = "https://www.wallpapertip.com/wmimgs/31-316097_mountain-wallpaper-hd-data-src-nature-mountain-wallpaper.jpg";
