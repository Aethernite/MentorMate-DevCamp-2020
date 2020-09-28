import React from 'react';
import { useDispatch } from 'react-redux';
import styled from 'styled-components';
import { uploadCommentFile } from '../../../store/slices/upload';

const Icon = styled.i`
 font-size: 20px;
 display: inline-block;
`;

const IconButton = styled.button`
background: none;
color: #bbbbbb;
padding: 10px 10px 0px 0px;
cursor: pointer;
border: none;
outline:none;
display: inline-block;
transition: transform 0.2s;


 &:focus{
    outline:0;
 }

 &:hover{
    transform: scale(1.2);
 }
`;

const CommentFileUploadButton = ({ postId }) => {
    const hiddenFileInput = React.useRef(null);
    const dispatch = useDispatch();

    const handleClick = () => {
        hiddenFileInput.current.click();
    };

    const handleChange = event => {
        const fileUploaded = event.target.files[0];
        handleFile(fileUploaded);
    };

    const handleFile = async (file) => {
        dispatch(uploadCommentFile({ file, postId }));
    }

    return (
        <div>
            <IconButton type="button"><Icon onClick={handleClick} className="fa fa-camera"></Icon></IconButton>
            <input
                type="file"
                accept="image/*"
                ref={hiddenFileInput}
                onChange={handleChange}
                style={{ display: 'none' }}
            />
        </div>
    );
}
export default CommentFileUploadButton;